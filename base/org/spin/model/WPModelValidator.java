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

import org.compiere.model.MClient;
import org.compiere.model.ModelValidationEngine;
import org.compiere.model.ModelValidator;
import org.compiere.model.PO;
import org.compiere.util.CLogger;
import org.compiere.util.DB;
import org.compiere.util.KeyNamePair;
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
		//	Valid Null
		if(po == null)
			return null;
		//	
		if(type != TYPE_BEFORE_NEW
				&& type != TYPE_BEFORE_CHANGE)
			return null;
		//	
		MLVEWarehouseProduct config = MLVEWarehouseProduct.getFromPO(po, false);
		//	Dixon Martinez 2015-01-08
		if(config == null) 
			return null;
		//	End Dixon Martinez
		//	
		if(type == TYPE_BEFORE_NEW
				|| type == TYPE_BEFORE_CHANGE
				&& !config.isValidToComplete()) {
			//	Valid
			config.validOnSave(type == TYPE_BEFORE_NEW);
		}
		//	Return
		return config.getErrorMsgTranslate();
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
		KeyNamePair [] tables = DB.getKeyNamePairs("SELECT CASE " + 
				"WHEN wp.IsValidToComplete = 'Y' THEN 1 ELSE -1 END " +
				", CASE WHEN wp.IsValidToComplete = 'Y' " + 
				"THEN replace(c.ColumnName, '_ID', '') ELSE t.TableName END TableName " + 
				"FROM LVE_WarehouseProduct wp " +
				"INNER JOIN AD_Table t ON(t.AD_Table_ID = wp.AD_Table_ID) " +
				"LEFT JOIN AD_Column c ON(c.AD_Column_ID = wp.Parent_Column_ID) " + 
				"WHERE wp.AD_Client_ID = ? " +
				"AND wp.IsActive = 'Y' " +
				"GROUP BY wp.IsValidToComplete, t.TableName, c.ColumnName " +
				"ORDER BY t.TableName", false, getAD_Client_ID());
		//	Valid Tables
		if(tables == null)
			return;
		//	Iterate over tables
		for (KeyNamePair table : tables) {
			//	Add Listener
			if(table.getKey() == -1)
				engine.addModelChange(table.getName(), listener);
			else if(table.getKey() == 1
					&& table.getName() != null)
				engine.addDocValidate(table.getName(), listener);
			log.fine("Table Added=" + table.toString());
		}
	}

	@Override
	public String docValidate(PO po, int timing) {
		//	Valid Null
		if(po == null)
			return null;
		//	
		if(timing != TIMING_BEFORE_COMPLETE)
			return null;
		//	
		MLVEWarehouseProduct config = MLVEWarehouseProduct.getFromPO(po, false);
		//	Valid Null
		if(config == null)
			return null;
		//	
		if(timing == TIMING_BEFORE_COMPLETE
				&& config.isValidToComplete()) {
			//	Valid
			config.validOnComplete();
		}
		//	Return
		return config.getErrorMsgTranslate();
	}
}
