-- 27/07/2014 12:42:36 AM CEST
-- LVE-ADempiere
CREATE TABLE LVE_WarehouseProduct (AD_Client_ID NUMBER(10) NOT NULL, AD_Org_ID NUMBER(10) NOT NULL, AD_Table_ID NUMBER(10) NOT NULL, Attribute_Column_ID NUMBER(10) DEFAULT NULL, Created DATE NOT NULL, CreatedBy NUMBER(10) NOT NULL, IsActive CHAR(1) DEFAULT 'Y' CHECK (IsActive IN ('Y','N')) NOT NULL, LVE_WarehouseProduct_ID NUMBER(10) NOT NULL, Name NVARCHAR2(60) NOT NULL, Processing CHAR(1) DEFAULT NULL , Product_Column_ID NUMBER(10) NOT NULL, Qty_Column_ID NUMBER(10) NOT NULL, Updated DATE NOT NULL, UpdatedBy NUMBER(10) NOT NULL, Warehouse_Column_ID NUMBER(10) NOT NULL, CONSTRAINT LVE_WarehouseProduct_Key PRIMARY KEY (LVE_WarehouseProduct_ID))
;

-- 25/07/2014 04:34:45 PM CEST
-- LVE-ADempiere
CREATE TABLE LVE_WarehouseProductLine (AD_Client_ID NUMBER(10) NOT NULL, AD_Org_ID NUMBER(10) NOT NULL, Created DATE NOT NULL, CreatedBy NUMBER(10) NOT NULL, Description NVARCHAR2(255) DEFAULT NULL , IsActive CHAR(1) DEFAULT 'Y' CHECK (IsActive IN ('Y','N')) NOT NULL, IsAlwaysSetMandatory CHAR(1) DEFAULT NULL  CHECK (IsAlwaysSetMandatory IN ('Y','N')), LVE_WarehouseProduct_ID NUMBER(10) NOT NULL, LVE_WarehouseProductLine_ID NUMBER(10) NOT NULL, M_Product_ID NUMBER(10) NOT NULL, MustBeStocked CHAR(1) DEFAULT NULL  CHECK (MustBeStocked IN ('Y','N')), M_Warehouse_ID NUMBER(10) NOT NULL, SeqNo NUMBER(10) DEFAULT NULL , Updated DATE NOT NULL, UpdatedBy NUMBER(10) NOT NULL, CONSTRAINT LVE_WarehouseProductLine_Key PRIMARY KEY (LVE_WarehouseProductLine_ID))
;

