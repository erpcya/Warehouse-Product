/******************************************************************************
 * Product: Adempiere ERP & CRM Smart Business Solution                       *
 * Copyright (C) 1999-2007 ComPiere, Inc. All Rights Reserved.                *
 * This program is free software, you can redistribute it and/or modify it    *
 * under the terms version 2 of the GNU General Public License as published   *
 * by the Free Software Foundation. This program is distributed in the hope   *
 * that it will be useful, but WITHOUT ANY WARRANTY, without even the implied *
 * warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.           *
 * See the GNU General Public License for more details.                       *
 * You should have received a copy of the GNU General Public License along    *
 * with this program, if not, write to the Free Software Foundation, Inc.,    *
 * 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA.                     *
 * For the text or an alternative of this public license, you may reach us    *
 * ComPiere, Inc., 2620 Augustine Dr. #245, Santa Clara, CA 95054, USA        *
 * or via info@compiere.org or http://www.compiere.org/license.html           *
 *****************************************************************************/
package org.spin.model;

import java.math.BigDecimal;
import java.sql.Timestamp;
import org.compiere.model.*;
import org.compiere.util.KeyNamePair;

/** Generated Interface for LVE_WarehouseProductLine
 *  @author Adempiere (generated) 
 *  @version Release 3.7.0LTS (1252452765)
 */
public interface I_LVE_WarehouseProductLine 
{

    /** TableName=LVE_WarehouseProductLine */
    public static final String Table_Name = "LVE_WarehouseProductLine";

    /** AD_Table_ID=53848 */
    public static final int Table_ID = MTable.getTable_ID(Table_Name);

    KeyNamePair Model = new KeyNamePair(Table_ID, Table_Name);

    /** AccessLevel = 3 - Client - Org 
     */
    BigDecimal accessLevel = BigDecimal.valueOf(3);

    /** Load Meta Data */

    /** Column name AD_Client_ID */
    public static final String COLUMNNAME_AD_Client_ID = "AD_Client_ID";

	/** Get Client.
	  * Client/Tenant for this installation.
	  */
	public int getAD_Client_ID();

    /** Column name AD_Org_ID */
    public static final String COLUMNNAME_AD_Org_ID = "AD_Org_ID";

	/** Set Organization.
	  * Organizational entity within client
	  */
	public void setAD_Org_ID (int AD_Org_ID);

	/** Get Organization.
	  * Organizational entity within client
	  */
	public int getAD_Org_ID();

    /** Column name Created */
    public static final String COLUMNNAME_Created = "Created";

	/** Get Created.
	  * Date this record was created
	  */
	public Timestamp getCreated();

    /** Column name CreatedBy */
    public static final String COLUMNNAME_CreatedBy = "CreatedBy";

	/** Get Created By.
	  * User who created this records
	  */
	public int getCreatedBy();

    /** Column name Description */
    public static final String COLUMNNAME_Description = "Description";

	/** Set Description.
	  * Optional short description of the record
	  */
	public void setDescription (String Description);

	/** Get Description.
	  * Optional short description of the record
	  */
	public String getDescription();

    /** Column name IsActive */
    public static final String COLUMNNAME_IsActive = "IsActive";

	/** Set Active.
	  * The record is active in the system
	  */
	public void setIsActive (boolean IsActive);

	/** Get Active.
	  * The record is active in the system
	  */
	public boolean isActive();

    /** Column name IsAlwaysSetMandatory */
    public static final String COLUMNNAME_IsAlwaysSetMandatory = "IsAlwaysSetMandatory";

	/** Set Is Always Set Mandatory	  */
	public void setIsAlwaysSetMandatory (boolean IsAlwaysSetMandatory);

	/** Get Is Always Set Mandatory	  */
	public boolean isAlwaysSetMandatory();

    /** Column name IsSetWarehouse */
    public static final String COLUMNNAME_IsSetWarehouse = "IsSetWarehouse";

	/** Set Is Set Warehouse	  */
	public void setIsSetWarehouse (boolean IsSetWarehouse);

	/** Get Is Set Warehouse	  */
	public boolean isSetWarehouse();

    /** Column name LVE_WarehouseProduct_ID */
    public static final String COLUMNNAME_LVE_WarehouseProduct_ID = "LVE_WarehouseProduct_ID";

	/** Set Warehouse of Product	  */
	public void setLVE_WarehouseProduct_ID (int LVE_WarehouseProduct_ID);

	/** Get Warehouse of Product	  */
	public int getLVE_WarehouseProduct_ID();

	public org.spin.model.I_LVE_WarehouseProduct getLVE_WarehouseProduct() throws RuntimeException;

    /** Column name LVE_WarehouseProductLine_ID */
    public static final String COLUMNNAME_LVE_WarehouseProductLine_ID = "LVE_WarehouseProductLine_ID";

	/** Set Warehouse Product Line	  */
	public void setLVE_WarehouseProductLine_ID (int LVE_WarehouseProductLine_ID);

	/** Get Warehouse Product Line	  */
	public int getLVE_WarehouseProductLine_ID();

    /** Column name M_Locator_ID */
    public static final String COLUMNNAME_M_Locator_ID = "M_Locator_ID";

	/** Set Locator.
	  * Warehouse Locator
	  */
	public void setM_Locator_ID (int M_Locator_ID);

	/** Get Locator.
	  * Warehouse Locator
	  */
	public int getM_Locator_ID();

	public org.compiere.model.I_M_Locator getM_Locator() throws RuntimeException;

    /** Column name M_Product_ID */
    public static final String COLUMNNAME_M_Product_ID = "M_Product_ID";

	/** Set Product.
	  * Product, Service, Item
	  */
	public void setM_Product_ID (int M_Product_ID);

	/** Get Product.
	  * Product, Service, Item
	  */
	public int getM_Product_ID();

	public org.compiere.model.I_M_Product getM_Product() throws RuntimeException;

    /** Column name MustBeStocked */
    public static final String COLUMNNAME_MustBeStocked = "MustBeStocked";

	/** Set Product quantity must be in stock.
	  * If not sufficient in stock in the warehouse, the BOM is not produced
	  */
	public void setMustBeStocked (boolean MustBeStocked);

	/** Get Product quantity must be in stock.
	  * If not sufficient in stock in the warehouse, the BOM is not produced
	  */
	public boolean isMustBeStocked();

    /** Column name M_Warehouse_ID */
    public static final String COLUMNNAME_M_Warehouse_ID = "M_Warehouse_ID";

	/** Set Warehouse.
	  * Storage Warehouse and Service Point
	  */
	public void setM_Warehouse_ID (int M_Warehouse_ID);

	/** Get Warehouse.
	  * Storage Warehouse and Service Point
	  */
	public int getM_Warehouse_ID();

	public org.compiere.model.I_M_Warehouse getM_Warehouse() throws RuntimeException;

    /** Column name SeqNo */
    public static final String COLUMNNAME_SeqNo = "SeqNo";

	/** Set Sequence.
	  * Method of ordering records;
 lowest number comes first
	  */
	public void setSeqNo (int SeqNo);

	/** Get Sequence.
	  * Method of ordering records;
 lowest number comes first
	  */
	public int getSeqNo();

    /** Column name Updated */
    public static final String COLUMNNAME_Updated = "Updated";

	/** Get Updated.
	  * Date this record was updated
	  */
	public Timestamp getUpdated();

    /** Column name UpdatedBy */
    public static final String COLUMNNAME_UpdatedBy = "UpdatedBy";

	/** Get Updated By.
	  * User who updated this records
	  */
	public int getUpdatedBy();
}
