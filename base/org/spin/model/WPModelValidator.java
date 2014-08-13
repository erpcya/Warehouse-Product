/******************************************************************************
 * Product: Adempiere ERP & CRM Smart Business Solution                       *
 * This program is free software; you can redistribute it and/or modify it    *
 * under the terms version 2 of the GNU General Public License as published   *
 * by the Free Software Foundation. This program is distributed in the hope   *
 * that it will be useful, but WITHOUT ANY WARRANTY; without even the implied *
 * warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.           *
 * See the GNU General Public License for more details.                       *
 * You should have received a copy of the GNU General Public License along    *
 * with this program; if not, write to the Free Software Foundation, Inc.,    *
 * 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA.                     *
 * For the text or an alternative of this public license, you may reach us    *
 * Copyright (C) 2003-2014 E.R.P. Consultores y Asociados.                    *
 * All Rights Reserved.                                                       *
 * Contributor(s): Yamel Senih www.erpconsultoresyasociados.com               *
 *****************************************************************************/
package org.spin.model;

import java.math.BigDecimal;

import org.compiere.model.MClient;
import org.compiere.model.MColumn;
import org.compiere.model.MStorage;
import org.compiere.model.MWarehouse;
import org.compiere.model.ModelValidationEngine;
import org.compiere.model.ModelValidator;
import org.compiere.model.PO;
import org.compiere.util.CLogger;
import org.compiere.util.DB;
import org.compiere.util.Env;
import org.compiere.util.KeyNamePair;
import org.compiere.util.Msg;

/**
 * @author <a href="mailto:yamelsenih@gmail.com">Yamel Senih</a> 26/07/2014, 13:17:14
 *
 */
public class WPModelValidator implements ModelValidator {

	/**
	 * *** Constructor ***
	 * @author <a href="mailto:yamelsenih@gmail.com">Yamel Senih</a> 26/07/2014, 13:17:14
	 */
	public WPModelValidator() {
		super();
	}

	/** Logger */
	private static CLogger log = CLogger.getCLogger(WPModelValidator.class);
	/** Client */
	private int m_AD_Client_ID = -1;
	
	@Override
	public void initialize(ModelValidationEngine engine, MClient client) {
		// client = null for global validator
		if (client != null) {
			m_AD_Client_ID = client.getAD_Client_ID();
			log.info(client.toString());
		} else {
			log.info("Initializing global validator: " + this.toString());
		}
		//	Add Warehouse Product Listener
		addWPListener(engine, this);
	}

	@Override
	public int getAD_Client_ID() {
		return m_AD_Client_ID;
	}

	@Override
	public String login(int AD_Org_ID, int AD_Role_ID, int AD_User_ID) {
		log.info("AD_User_ID=" + AD_User_ID);
		return null;
	}

	@Override
	public String modelChange(PO po, int type) throws Exception {
		String msg = validWarehouseProduct(po, type);
		return msg;
	}
	
	/**
	 * Valid Warehouse Product Configuration
	 * @author <a href="mailto:yamelsenih@gmail.com">Yamel Senih</a> 26/07/2014, 13:17:14
	 * @param po
	 * @param type
	 * @return
	 * @return String
	 */
	private String validWarehouseProduct(PO po, int type) {
		//	Valid Null
		if(po == null)
			return null;
		//	
		if(type != TYPE_BEFORE_NEW
				&& type != TYPE_BEFORE_CHANGE)
			return null;
		//	
		String msg = null;
		//	do It
		//	Get From Table
		MLVEWarehouseProduct wProductConfig = MLVEWarehouseProduct
				.getFromTable(po.getCtx(), po.get_Table_ID(), true);
		//	Valid Null
		if(wProductConfig == null)
			return null;
		
		//	Get Column Names
		String m_Product_Column = MColumn.getColumnName(po.getCtx(), wProductConfig.getProduct_Column_ID());
		String m_Attribute_Column = MColumn.getColumnName(po.getCtx(), wProductConfig.getAttribute_Column_ID());
		String m_Warehouse_Column = MColumn.getColumnName(po.getCtx(), wProductConfig.getWarehouse_Column_ID());
		String m_Qty_Column = MColumn.getColumnName(po.getCtx(), wProductConfig.getQty_Column_ID());
		//	Get Values
		int m_AD_Org_ID = po.getAD_Org_ID();
		int m_M_Product_ID = po.get_ValueAsInt(m_Product_Column);
		int m_M_AttributeSetInstance_ID = 0;
		if(m_Attribute_Column != null)
			m_M_AttributeSetInstance_ID = po.get_ValueAsInt(m_Attribute_Column);
		
		int m_M_Warehouse_ID = po.get_ValueAsInt(m_Warehouse_Column);
		int m_OldWarehouse_ID = po.get_ValueOldAsInt(m_Warehouse_Column);
		BigDecimal m_Qty = (BigDecimal) po.get_Value(m_Qty_Column);
		if(m_Qty == null)
			m_Qty = Env.ZERO;
		//	Valid Configuration
		if(type == TYPE_BEFORE_CHANGE) {
			MLVEWarehouseProductLine configLine = MLVEWarehouseProduct.getWarehouseProduct(po.getCtx(), po.get_Table_ID(), 
					m_AD_Org_ID, m_M_Product_ID, m_OldWarehouse_ID, po.get_TrxName());
			if(configLine == null)
				return null;
			m_M_Warehouse_ID = configLine.getM_Warehouse_ID();
			//	Valid Mandatory
			if(configLine.isAlwaysSetMandatory()) {
				po.set_ValueOfColumn(m_Warehouse_Column, m_OldWarehouse_ID);
				m_M_Warehouse_ID = m_OldWarehouse_ID; 
			}
			//	Valid Stock
			if(configLine.isMustBeStocked()) {
				BigDecimal available = MStorage.getQtyAvailable
						(m_M_Warehouse_ID, 0, m_M_Product_ID, m_M_AttributeSetInstance_ID, null);
				if (available == null)
					available = Env.ZERO;
				if (available.signum() == 0)
					msg = "@NoQtyAvailable@";
				else if (available.compareTo(m_Qty) < 0)
					msg = "@InsufficientQtyAvailable@ [@QtyAvailable@ = " + available.toString() 
								+ " @Qty@ = " + m_Qty + " @Difference@ = " + m_Qty.subtract(available) + "]";
			}
		} else if(type == TYPE_BEFORE_NEW) {
			//	Get Combination
			MLVEWarehouseProductLine [] combination = MLVEWarehouseProduct
					.getWPCombination(po.getCtx(), po.get_Table_ID(), m_AD_Org_ID, m_M_Product_ID, po.get_TrxName());
			//	Valid Combination
			if(combination == null)
				return null;
			//	
			BigDecimal available = Env.ZERO;
			//	Is Stocked
			boolean isMustBeStocked = false;
			//	Iterate
			for(MLVEWarehouseProductLine line : combination) {
				//	Get Values
				m_M_Warehouse_ID = line.getM_Warehouse_ID();
				//	
				isMustBeStocked = line.isMustBeStocked();
				if(isMustBeStocked) {
					available = MStorage.getQtyAvailable
							(m_M_Warehouse_ID, 0, m_M_Product_ID, m_M_AttributeSetInstance_ID, null);
					if (available == null)
						available = Env.ZERO;
					//	Set Available
					available = available.subtract(m_Qty);
					if (available.compareTo(Env.ZERO) >= 0)
						break;
				} else {
					break;
				}
			}
			//	
			if (available.compareTo(m_Qty) < 0
					&& isMustBeStocked) {
				MWarehouse warehouse = MWarehouse.get(po.getCtx(), m_M_Warehouse_ID);
				//	Msg
				msg = "@InsufficientQtyAvailable@ [@M_Warehouse_ID@ = " + warehouse.getName() 
						+ ", @QtyAvailable@ = " + available.toString() 
						+ " @Qty@ = " + m_Qty + " @Difference@ = " + m_Qty.subtract(available) + "]";
			}
			//	Set Warehouse
			po.set_ValueOfColumn(m_Warehouse_Column, m_M_Warehouse_ID);
			//	Valid Stock
		}
		//	Return
		return Msg.parseTranslation(po.getCtx(), msg);
	}
	
	/**
	 * Add Warehouse Product Listener
	 * @author <a href="mailto:yamelsenih@gmail.com">Yamel Senih</a> 28/07/2014, 17:29:30
	 * @param engine
	 * @param listener
	 * @return void
	 */
	private void addWPListener(ModelValidationEngine engine, ModelValidator listener) {
		//	Valid Null
		if(engine == null
				|| listener == null)
			return;
		KeyNamePair [] tables = DB.getKeyNamePairs("SELECT t.AD_Table_ID, t.TableName " +
				"FROM LVE_WarehouseProduct wp " +
				"INNER JOIN AD_Table t ON(t.AD_Table_ID = wp.AD_Table_ID) " +
				"WHERE wp.AD_Client_ID = ? " +
				"AND wp.IsActive = 'Y' " +
				"GROUP BY t.AD_Table_ID, t.TableName " +
				"ORDER BY t.TableName", false, getAD_Client_ID());
		//	Valid Tables
		if(tables == null)
			return;
		//	Iterate over tables
		for (KeyNamePair table : tables) {
			//	Add Listener
			engine.addModelChange(table.getName(), listener);
			log.fine("Table Added=" + table.toString());
		}
	}

	@Override
	public String docValidate(PO po, int timing) {
		return null;
	}
}
