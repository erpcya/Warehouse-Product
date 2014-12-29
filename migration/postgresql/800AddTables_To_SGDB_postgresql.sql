-- Nov 20, 2014 10:52:09 AM VET
-- Warehouse Product
CREATE TABLE LVE_WarehouseProduct (AD_Client_ID NUMERIC(10) NOT NULL, AD_Org_ID NUMERIC(10) NOT NULL, AD_Table_ID NUMERIC(10) NOT NULL, Attribute_Column_ID NUMERIC(10) DEFAULT NULL , Created TIMESTAMP NOT NULL, CreatedBy NUMERIC(10) NOT NULL, IsActive CHAR(1) DEFAULT 'Y' CHECK (IsActive IN ('Y','N')) NOT NULL, IsSOTrx CHAR(1) DEFAULT NULL CHECK (IsSOTrx IN ('Y','N')), Locator_Column_ID NUMERIC(10) DEFAULT NULL , LVE_WarehouseProduct_ID NUMERIC(10) NOT NULL, Name VARCHAR(60) NOT NULL, Parent_Column_ID NUMERIC(10) DEFAULT NULL , Processing CHAR(1) DEFAULT NULL , Product_Column_ID NUMERIC(10) NOT NULL, Qty_Column_ID NUMERIC(10) NOT NULL, Updated TIMESTAMP NOT NULL, UpdatedBy NUMERIC(10) NOT NULL, Warehouse_Column_ID NUMERIC(10) NOT NULL, CONSTRAINT LVE_WarehouseProduct_Key PRIMARY KEY (LVE_WarehouseProduct_ID))
;

-- Nov 20, 2014 10:52:14 AM VET
-- Warehouse Product
CREATE TABLE LVE_WarehouseProductLine (AD_Client_ID NUMERIC(10) NOT NULL, AD_Org_ID NUMERIC(10) NOT NULL, Created TIMESTAMP NOT NULL, CreatedBy NUMERIC(10) NOT NULL, Description VARCHAR(255) DEFAULT NULL , IsActive CHAR(1) DEFAULT 'Y' CHECK (IsActive IN ('Y','N')) NOT NULL, IsAlwaysSetMandatory CHAR(1) DEFAULT NULL CHECK (IsAlwaysSetMandatory IN ('Y','N')), LVE_WarehouseProduct_ID NUMERIC(10) NOT NULL, LVE_WarehouseProductLine_ID NUMERIC(10) NOT NULL, M_Product_ID NUMERIC(10) NOT NULL, MustBeStocked CHAR(1) DEFAULT NULL CHECK (MustBeStocked IN ('Y','N')), M_Warehouse_ID NUMERIC(10) NOT NULL, SeqNo NUMERIC(10) DEFAULT NULL , Updated TIMESTAMP NOT NULL, UpdatedBy NUMERIC(10) NOT NULL, CONSTRAINT LVE_WarehouseProductLine_Key PRIMARY KEY (LVE_WarehouseProductLine_ID))
;

-- Alter Table
ALTER TABLE LVE_WarehouseProduct ALTER COLUMN Warehouse_Column_ID DROP NOT NULL;