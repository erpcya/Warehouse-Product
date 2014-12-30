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
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.adempiere.exceptions.AdempiereException;
import org.compiere.model.MColumn;
import org.compiere.model.MQuery;
import org.compiere.model.MStorage;
import org.compiere.model.MTable;
import org.compiere.model.MWarehouse;
import org.compiere.model.PO;
import org.compiere.model.Query;
import org.compiere.util.CCache;
import org.compiere.util.DB;
import org.compiere.util.Env;
import org.compiere.util.Msg;

/**
 * @author <a href="mailto:yamelsenih@gmail.com">Yamel Senih</a>
 *
 */
public class MLVEWarehouseProduct extends X_LVE_WarehouseProduct {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1994668061472867078L;
	
	/**
	 * *** Constructor ***
	 * @author <a href="mailto:yamelsenih@gmail.com">Yamel Senih</a> 25/07/2014, 17:26:18
	 * @param ctx
	 * @param LVE_WarehouseProduct_ID
	 * @param trxName
	 */
	public MLVEWarehouseProduct(Properties ctx, int LVE_WarehouseProduct_ID,
			String trxName) {
		super(ctx, LVE_WarehouseProduct_ID, trxName);
	}

	/**
	 * *** Constructor ***
	 * @author <a href="mailto:yamelsenih@gmail.com">Yamel Senih</a> 25/07/2014, 17:26:18
	 * @param ctx
	 * @param rs
	 * @param trxName
	 */
	public MLVEWarehouseProduct(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
	}
	
	/** Cache */
	public static CCache<Integer, MLVEWarehouseProduct> s_cacheByTable = new CCache<Integer, MLVEWarehouseProduct>(Table_Name, 10);

	/**	PO							*/
	private PO 			m_PO 							= null;
	/**	Parent PO					*/
	private PO			m_ParentPO 						= null;
	/**	Organization				*/
	private int 		m_AD_Org_ID						= 0;
	/**	Product						*/
	private int 		m_M_Product_ID					= 0;
	/**	Attribute Set Instance		*/
	private int 		m_M_AttributeSetInstance_ID 	= 0;
	/**	Warehouse					*/
	private int 		m_M_Warehouse_ID 				= 0;
	/**	Warehouse Old				*/
	private int 		m_OldWarehouse_ID				= 0;
	/**	Locator						*/
	private int 		m_M_Locator_ID 					= 0;
	/**	Locator Old					*/
	private int 		m_OldLocator_ID 				= 0;
	/**	Quantity					*/
	private BigDecimal 	m_Qty							= Env.ZERO;
	/**	Error Message				*/
	private String		m_ErrorMsg						= null;
	
	@Override
	protected boolean beforeSave(boolean newRecord) {
		super.beforeSave(newRecord);
		//	Valid Warehouse and Locator
		if(getWarehouse_Column_ID() <= 0
				&& getLocator_Column_ID() <=0)
			throw new AdempiereException("[@Warehouse_Column_ID@ / @Locator_Column_ID@] "
					+ "@NotFound@");
		return true;
	}
	
	/***************************************************************************
	 * Helper Methods                                                          *
	 ***************************************************************************/

	/**
	 * Get Default Warehouse from Product
	 * @author <a href="mailto:yamelsenih@gmail.com">Yamel Senih</a> 25/07/2014, 19:25:27
	 * @param cxt
	 * @param p_AD_Table_ID
	 * @param p_AD_Org_ID
	 * @param p_M_Product_ID
	 * @param p_M_Warehouse_ID
	 * @param trxName
	 * @return
	 * @return MLVEWarehouseProductLine
	 */
	public static MLVEWarehouseProductLine getWarehouseProduct(Properties ctx, int p_AD_Table_ID, 
			int p_AD_Org_ID, int p_M_Product_ID, int p_M_Warehouse_ID, String trxName) {
		//	Get Warehouse Configuration
		int m_LVE_WarehouseProductLine_ID = DB.getSQLValue(trxName, "SELECT wpl.LVE_WarehouseProductLine_ID " +
				"FROM LVE_WarehouseProduct wp " +
				"INNER JOIN LVE_WarehouseProductLine wpl ON(wp.LVE_WarehouseProduct_ID = wpl.LVE_WarehouseProduct_ID) " +
				"WHERE wp.AD_Table_ID = ? " +
				"AND wpl.AD_Org_ID = ? " +
				"AND wpl.M_Product_ID = ? " +
				"AND wpl.IsActive = 'Y' " +
				"AND wpl.M_Warehouse_ID = " + p_M_Warehouse_ID + " " +
				"AND wp.IsActive = 'Y' " +
				"ORDER BY wpl.SeqNo", new Object[]{p_AD_Table_ID, p_AD_Org_ID, p_M_Product_ID});
		//	Return
		if(m_LVE_WarehouseProductLine_ID <= 0)
			return null;
		//	
		return MLVEWarehouseProductLine.get(ctx, m_LVE_WarehouseProductLine_ID);
	}
	
	/**
	 * Get Warehouse Product Combination
	 * @param ctx
	 * @param p_AD_Table_ID
	 * @param p_AD_Org_ID
	 * @param p_M_Product_ID
	 * @param trxName
	 * @return
	 */
	public static MLVEWarehouseProductLine[] getWPCombination(Properties ctx, int p_AD_Table_ID, 
			int p_AD_Org_ID, int p_M_Product_ID, String trxName) {
		//	Get Warehouse Configuration
		//	Where Clause
		StringBuffer whereClause = new StringBuffer();
		//	Parameters
		ArrayList<Object> params = new ArrayList<Object>();
		//	Add Org
		whereClause.append(I_LVE_WarehouseProductLine.COLUMNNAME_AD_Org_ID).append(" = ?");
		params.add(p_AD_Org_ID);
		//	Add Product
		whereClause.append(" AND ").append(I_LVE_WarehouseProductLine.COLUMNNAME_M_Product_ID).append(" = ?");
		params.add(p_M_Product_ID);
		//	Add Header Validation
		whereClause.append(" AND EXISTS(SELECT 1 " +
				"FROM LVE_WarehouseProduct wp " +
				"WHERE wp.LVE_WarehouseProduct_ID = LVE_WarehouseProductLine.LVE_WarehouseProduct_ID " +
				"AND wp.AD_Table_ID = ? " +
				"AND wp.IsActive = 'Y')");
		params.add(p_AD_Table_ID);		
		//	Valid
		//	Get Combination
		List<MLVEWarehouseProductLine> list = new Query(ctx, I_LVE_WarehouseProductLine.Table_Name, whereClause.toString(), trxName)
				.setParameters(params)
				.setOnlyActiveRecords(true)
				.setOrderBy(I_LVE_WarehouseProductLine.COLUMNNAME_SeqNo)
				.<MLVEWarehouseProductLine>list();
		//	Convert to Array
		MLVEWarehouseProductLine [] combinations = new MLVEWarehouseProductLine[list.size()];
		list.toArray(combinations);
		//	Return
		return combinations;
	}
	
	/**
	 * Get from Table and Org
	 * @author <a href="mailto:yamelsenih@gmail.com">Yamel Senih</a> 27/07/2014, 00:16:54
	 * @param ctx
	 * @param p_AD_Table_ID
	 * @param p_AD_Org_ID
	 * @param p_IsSOTrx
	 * @return
	 * @return MLVEWarehouseProduct
	 */
	public static MLVEWarehouseProduct getFromTable(Properties ctx, int p_AD_Table_ID, int p_AD_Org_ID, boolean p_IsSOTrx) {
		if (p_AD_Table_ID <= 0)
			return null;
		//
		MLVEWarehouseProduct wProduct = s_cacheByTable.get(p_AD_Table_ID);
		if (wProduct != null)
			return wProduct;
		//	Get From DB
		int m_LVE_WarehouseProduct_ID = DB.getSQLValue(null, "SELECT wp.LVE_WarehouseProduct_ID " +
				"FROM LVE_WarehouseProduct wp " + 
				"WHERE wp.AD_Table_ID = ? " +
				"AND wp.IsActive = 'Y' " +
				"AND wp.AD_Org_ID = ? " + 
				"AND wp.IsSOTrx = ? ", 
				new Object[] {p_AD_Table_ID, p_AD_Org_ID, (p_IsSOTrx? "Y": "N")});
		//	
		wProduct = new MLVEWarehouseProduct(ctx, m_LVE_WarehouseProduct_ID, null);
		if (wProduct.get_ID() == m_LVE_WarehouseProduct_ID) {
			s_cacheByTable.put(p_AD_Table_ID, wProduct);
		} else {
			wProduct = null;
		}
		//	Return
		return wProduct;
	}
	
	/**
	 * Valid Warehouse Product Configuration
	 * @author <a href="mailto:waditzar.c@gmail.com">Waditza Rivas</a> 26/07/2014, 13:17:14
	 * @contributor <a href="mailto:yamelsenih@gmail.com">Yamel Senih</a> 20/11/2014, 11:23:10
	 * <li> Fixed error with record ID
	 * @param po
	 * @param type
	 * @return
	 * @return String
	 */
	private static PO getParentPO(PO po, String m_Parent_Column_Name) {
		//	Valid null
		if(m_Parent_Column_Name == null
				|| m_Parent_Column_Name.trim().length() == 0)
			return null;
		//	get table name
		String tablename = MQuery.getZoomTableName(m_Parent_Column_Name);
		MTable table = MTable.get(po.getCtx(), tablename);
		PO parent = table.getPO(po.get_ValueAsInt(m_Parent_Column_Name), po.get_TrxName());
		//	Return
		return parent;
	}
	
	/**
	 * Get Configuration from PO
	 * @author <a href="mailto:yamelsenih@gmail.com">Yamel Senih</a> 30/12/2014, 14:37:29
	 * @param po
	 * @return
	 * @return MLVEWarehouseProduct
	 */
	public static MLVEWarehouseProduct getFromPO(PO po) {
		//	
		MLVEWarehouseProduct wProductConfig = MLVEWarehouseProduct
				.getFromTable(po.getCtx(), po.get_Table_ID(), po.getAD_Org_ID(), true);
		//	Valid Null
		if(wProductConfig == null) {
			wProductConfig = MLVEWarehouseProduct
					.getFromTable(po.getCtx(), po.get_Table_ID(), po.getAD_Org_ID(), false);
		}
		//	Valid Null
		if(wProductConfig == null)
			return null;
		// Parent PO
		PO parentPO = getParentPO(po, wProductConfig.getParent_ColumnName());
		//	Get IsSOTrx
		String isSOTrx = po.get_ValueAsString(I_LVE_WarehouseProduct.COLUMNNAME_IsSOTrx);
		//	Yamel Senih 2014-12-19, 12:47:55
		//	Add Validation for Is Sales Order Transaction 
		//if Null isSOTrx
		if(isSOTrx == null 
				 && parentPO != null)
		{
			isSOTrx = parentPO.get_ValueAsString(I_LVE_WarehouseProduct.COLUMNNAME_IsSOTrx);
		}//end if
		//	Valid Sales Order Transaction
		if(isSOTrx == null)
			isSOTrx = "N";
		//	Get Warehouse Product
		wProductConfig = MLVEWarehouseProduct
				.getFromTable(po.getCtx(), po.get_Table_ID(), po.getAD_Org_ID(), isSOTrx.equals("Y"));
		//	End Yamel Senih
		//	Return
		return wProductConfig;
	}
	
	/**
	 * Get Parent Column Name
	 * @author <a href="mailto:yamelsenih@gmail.com">Yamel Senih</a> 30/12/2014, 14:58:41
	 * @return
	 * @return String
	 */
	public String getParent_ColumnName() {
		return getColumnName(getParent_Column_ID());
	}
	
	/**
	 * Get Product Column Name
	 * @author <a href="mailto:yamelsenih@gmail.com">Yamel Senih</a> 30/12/2014, 15:01:27
	 * @return
	 * @return String
	 */
	public String getProduct_ColumnName() {
		return getColumnName(getProduct_Column_ID());
	}
	
	/**
	 * Get Attribute Column Name
	 * @author <a href="mailto:yamelsenih@gmail.com">Yamel Senih</a> 30/12/2014, 15:01:38
	 * @return
	 * @return String
	 */
	public String getAttribute_ColumnName() {
		return getColumnName(getAttribute_Column_ID());
	}
	
	/**
	 * Get Warehouse Column Name
	 * @author <a href="mailto:yamelsenih@gmail.com">Yamel Senih</a> 30/12/2014, 15:01:55
	 * @return
	 * @return String
	 */
	public String getWarehouse_ColumnName() {
		return getColumnName(getWarehouse_Column_ID());
	}
	
	/**
	 * Get Locator Column Name
	 * @author <a href="mailto:yamelsenih@gmail.com">Yamel Senih</a> 30/12/2014, 15:02:06
	 * @return
	 * @return String
	 */
	public String getLocator_ColumnName() {
		return getColumnName(getLocator_Column_ID());
	}
	
	/**
	 * Get Quantity Column Name
	 * @author <a href="mailto:yamelsenih@gmail.com">Yamel Senih</a> 30/12/2014, 15:02:15
	 * @return
	 * @return String
	 */
	public String getQty_ColumnName() {
		return getColumnName(getQty_Column_ID());
	}
	
	/**
	 * Get Column Name
	 * @author <a href="mailto:yamelsenih@gmail.com">Yamel Senih</a> 30/12/2014, 14:58:07
	 * @param p_AD_Column_ID
	 * @return
	 * @return String
	 */
	private String getColumnName(int p_AD_Column_ID) {
		return MColumn.getColumnName(getCtx(), p_AD_Column_ID);
	}
	
	/**
	 * Load Values for PO
	 * @author <a href="mailto:yamelsenih@gmail.com">Yamel Senih</a> 30/12/2014, 15:21:15
	 * @param p_PO
	 * @return void
	 */
	public void loadValues(PO p_PO) {
		//	Get PO and Parent PO
		m_PO = p_PO;
		m_ParentPO = getParentPO(m_PO, getParent_ColumnName());
		//	Organization
		m_AD_Org_ID = m_PO.getAD_Org_ID();
		//	Product
		m_M_Product_ID = m_PO.get_ValueAsInt(getProduct_ColumnName());
		//	Handle Attribute
		m_M_AttributeSetInstance_ID = 0;
		//	Valid Attribute
		String m_Attribute_Column = getAttribute_ColumnName();
		if(m_Attribute_Column != null)
			m_M_AttributeSetInstance_ID = m_PO.get_ValueAsInt(m_Attribute_Column);
		//	Handle Warehouse
		String m_Warehouse_Column = getWarehouse_ColumnName();
		m_M_Warehouse_ID = 0;
		m_OldWarehouse_ID = 0;
		if(m_Warehouse_Column != null) {
			m_M_Warehouse_ID = m_PO.get_ValueAsInt(m_Warehouse_Column);
			m_OldWarehouse_ID = m_PO.get_ValueOldAsInt(m_Warehouse_Column);
		}
		//	Handle Locator
		String m_Locator_Column = getLocator_ColumnName();
		m_M_Locator_ID = 0;
		m_OldLocator_ID = 0;
		//	Valid Locator
		if(m_Locator_Column != null) {
			m_M_Locator_ID = m_PO.get_ValueAsInt(m_Locator_Column);
			m_OldLocator_ID = m_PO.get_ValueOldAsInt(m_Locator_Column);
		}
		//	Quantity
		m_Qty = (BigDecimal) m_PO.get_Value(getQty_ColumnName());
		//	Get From Parent
		if(m_ParentPO != null) {
			//	Organization
			if(m_AD_Org_ID == 0)
				m_AD_Org_ID = m_ParentPO.getAD_Org_ID();
			//	Product
			if(m_M_Product_ID == 0)
				m_M_Product_ID = m_ParentPO.get_ValueAsInt(getProduct_ColumnName());
			//	Attribute
			if(m_Attribute_Column != null
					&& m_M_AttributeSetInstance_ID == 0)
				m_M_AttributeSetInstance_ID = m_ParentPO.get_ValueAsInt(m_Attribute_Column);
			//	Warehouse
			if(m_Warehouse_Column == null) {
				if(m_M_Warehouse_ID == 0)
					m_M_Warehouse_ID = m_ParentPO.get_ValueAsInt(m_Warehouse_Column);
				if(m_OldWarehouse_ID == 0)
					m_OldWarehouse_ID = m_ParentPO.get_ValueOldAsInt(m_Warehouse_Column);
			}
			//	Locator
			if(m_Locator_Column == null) {
				if(m_M_Locator_ID == 0)
					m_M_Locator_ID = m_ParentPO.get_ValueAsInt(m_Locator_Column);
				if(m_OldLocator_ID == 0)
					m_OldLocator_ID = m_ParentPO.get_ValueOldAsInt(m_Locator_Column);
			}
			//	Quantity
			if(m_Qty == null)
				m_ParentPO.get_Value(getQty_ColumnName());
		}
		//	Set Quantity
		if(m_Qty == null)
			m_Qty = Env.ZERO;
	}

	/**
	 * Valid On Save Event
	 * @author <a href="mailto:yamelsenih@gmail.com">Yamel Senih</a> 30/12/2014, 15:49:33
	 * @param newRecord
	 * @return
	 * @return boolean
	 */
	public boolean validOnSave(boolean newRecord) {
		//	Set Error to Void
		m_ErrorMsg = null;
		//	If is a new record
		if(!newRecord) {
			MLVEWarehouseProductLine configLine = MLVEWarehouseProduct.getWarehouseProduct(getCtx(), m_PO.get_Table_ID(), 
					m_AD_Org_ID, m_M_Product_ID, m_OldWarehouse_ID, m_PO.get_TrxName());
			if(configLine == null)
				return true;
			m_M_Warehouse_ID = configLine.getM_Warehouse_ID();
			//	Valid Mandatory
			if(configLine.isSetWarehouse()
					&& configLine.isAlwaysSetMandatory()) {
				String m_Warehouse_Column = getLocator_ColumnName();
				if(m_Warehouse_Column != null) {
					m_PO.set_ValueOfColumn(m_Warehouse_Column, m_OldWarehouse_ID);
					m_M_Warehouse_ID = m_OldWarehouse_ID;
				}
				//	Handle Locator
				String m_Locator_Column = getLocator_ColumnName();
				if(m_Locator_Column != null) {
					m_PO.set_ValueOfColumn(m_Locator_Column, m_OldLocator_ID);
					m_M_Locator_ID = m_OldLocator_ID;
				}
			}
			//	Valid Stock
			if(configLine.isMustBeStocked()) {
				BigDecimal available = MStorage.getQtyAvailable
						(m_M_Warehouse_ID, m_M_Locator_ID, m_M_Product_ID, m_M_AttributeSetInstance_ID, null);
				if (available == null)
					available = Env.ZERO;
				if (available.signum() == 0)
					m_ErrorMsg = "@NoQtyAvailable@";
				else if (available.compareTo(m_Qty) < 0)
					m_ErrorMsg = "@InsufficientQtyAvailable@ [@QtyAvailable@ = " + available.toString() 
								+ " @Qty@ = " + m_Qty + " @Difference@ = " + m_Qty.subtract(available) + "]";
			}
		} else {
			//	Get Combination
			MLVEWarehouseProductLine [] combination = MLVEWarehouseProduct
					.getWPCombination(m_PO.getCtx(), m_PO.get_Table_ID(), m_AD_Org_ID, m_M_Product_ID, m_PO.get_TrxName());
			//	Valid Combination
			if(combination == null)
				return true;
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
							(m_M_Warehouse_ID, m_M_Locator_ID, m_M_Product_ID, m_M_AttributeSetInstance_ID, null);
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
				MWarehouse warehouse = MWarehouse.get(m_PO.getCtx(), m_M_Warehouse_ID);
				//	Msg
				m_ErrorMsg = "@InsufficientQtyAvailable@ [@M_Warehouse_ID@ = " + warehouse.getName() 
						+ ", @QtyAvailable@ = " + available.toString() 
						+ " @Qty@ = " + m_Qty + " @Difference@ = " + m_Qty.subtract(available) + "]";
			}
			//	Set Warehouse
			String m_Warehouse_Column = getLocator_ColumnName();
			if(m_Warehouse_Column != null) {
				m_PO.set_ValueOfColumn(m_Warehouse_Column, m_M_Warehouse_ID);
			}
			//	Set Locator
			String m_Locator_Column = getLocator_ColumnName();
			if(m_Locator_Column != null) {
				m_PO.set_ValueOfColumn(m_Locator_Column, m_M_Locator_ID);
			}
			//	Valid Stock
		}
		//	
		return (m_ErrorMsg != null);
	}
	
	//	String key = po.get_KeyColumns()[0];
	//	//	
	//	StringBuffer sqlQty = null;
	//	//		
	//	if(parentPO != null) {
	//		sqlQty = new StringBuffer("SELECT SUM(");
	//		sqlQty.append(m_Qty_Column).append(") ");
	//		sqlQty.append("FROM ");
	//		sqlQty.append(po.get_TableName()).append(" ");
	//		sqlQty.append("WHERE ");
	//		sqlQty.append(key).append(" <> ").append(po.get_ID());
	//		//	Add Parent if is required
	//		sqlQty.append(" AND ");
	//		//sqlQty.append(m_Product_Column).append(" = ").append()
	//		sqlQty.append(m_Parent_Column_Name).append(" = ");
	//		sqlQty.append(parentPO.get_ID());
	//		//	Group by
	//		sqlQty.append(" GROUP BY ").append(m_Product_Column);
	//	}
	
	/**
	 * @return the m_PO
	 */
	public PO getPO() {
		return m_PO;
	}

	/**
	 * @return the m_ParentPO
	 */
	public PO getParentPO() {
		return m_ParentPO;
	}

	/**
	 * @return the m_AD_Org_ID
	 */
	public int getAD_Org_ID() {
		return m_AD_Org_ID;
	}

	/**
	 * @return the m_M_Product_ID
	 */
	public int getM_Product_ID() {
		return m_M_Product_ID;
	}

	/**
	 * @return the m_M_AttributeSetInstance_ID
	 */
	public int getM_AttributeSetInstance_ID() {
		return m_M_AttributeSetInstance_ID;
	}

	/**
	 * @return the m_M_Warehouse_ID
	 */
	public int getM_Warehouse_ID() {
		return m_M_Warehouse_ID;
	}

	/**
	 * @return the m_OldWarehouse_ID
	 */
	public int getOldWarehouse_ID() {
		return m_OldWarehouse_ID;
	}

	/**
	 * @return the m_M_Locator_ID
	 */
	public int getM_Locator_ID() {
		return m_M_Locator_ID;
	}

	/**
	 * @return the m_OldLocator_ID
	 */
	public int getOldLocator_ID() {
		return m_OldLocator_ID;
	}

	/**
	 * @return the m_Qty
	 */
	public BigDecimal getQty() {
		return m_Qty;
	}
	
	/**
	 * @return the m_ErrorMsg
	 */
	public String getErrorMsg() {
		return m_ErrorMsg;
	}
	
	/**
	 * Get error with translation
	 * @author <a href="mailto:yamelsenih@gmail.com">Yamel Senih</a> 30/12/2014, 15:55:18
	 * @return
	 * @return String
	 */
	public String getErrorMsgTranslate() {
		return Msg.parseTranslation(getCtx(), m_ErrorMsg);
	}

	@Override
	public String toString() {
		return "MLVEWarehouseProduct [getAD_Table_ID()=" + getAD_Table_ID()
				+ ", isSOTrx()=" + isSOTrx() + ", getName()=" + getName() + "]";
	}
}
