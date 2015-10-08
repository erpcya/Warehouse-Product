-- Dec 29, 2014 3:42:27 PM CET
-- LVE- Warehouse Product
INSERT INTO AD_Val_Rule (AD_Client_ID,AD_Org_ID,AD_Val_Rule_ID,Code,Created,CreatedBy,Description,EntityType,IsActive,Name,Type,Updated,UpdatedBy) VALUES (0,0,52417,'AD_Column.AD_Table_ID = @AD_Table_ID@ OR EXISTS(SELECT 1 FROM AD_Table t WHERE t.AD_Table_ID = AD_Column.AD_Table_ID AND t.TableName = (SELECT REPLACE(c.ColumnName,''_ID'','''') FROM AD_Column c WHERE c.AD_Column_ID = @Parent_Column_ID@))',TO_DATE('2014-12-29 15:42:17','YYYY-MM-DD HH24:MI:SS'),100,'Table must be previously defined','ECA02','Y','AD_Column in AD_Table And Parent','S',TO_DATE('2014-12-29 15:42:17','YYYY-MM-DD HH24:MI:SS'),100)
;

-- Dec 29, 2014 3:42:52 PM CET
-- LVE- Warehouse Product
UPDATE AD_Column SET AD_Val_Rule_ID=52417,Updated=TO_DATE('2014-12-29 15:42:52','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Column_ID=73851
;

-- Dec 29, 2014 3:43:08 PM CET
-- LVE- Warehouse Product
UPDATE AD_Column SET AD_Val_Rule_ID=52417,Updated=TO_DATE('2014-12-29 15:43:08','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Column_ID=74318
;

-- Dec 29, 2014 3:43:17 PM CET
-- LVE- Warehouse Product
UPDATE AD_Column SET AD_Val_Rule_ID=52417,Updated=TO_DATE('2014-12-29 15:43:17','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Column_ID=73850
;

-- Dec 29, 2014 3:43:24 PM CET
-- LVE- Warehouse Product
UPDATE AD_Column SET AD_Val_Rule_ID=52417,Updated=TO_DATE('2014-12-29 15:43:24','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Column_ID=73853
;

-- Dec 29, 2014 3:43:30 PM CET
-- LVE- Warehouse Product
UPDATE AD_Column SET AD_Val_Rule_ID=52417,Updated=TO_DATE('2014-12-29 15:43:30','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Column_ID=73852
;

-- Dec 29, 2014 3:43:46 PM CET
-- LVE- Warehouse Product
UPDATE AD_Column SET IsUpdateable='N',Updated=TO_DATE('2014-12-29 15:43:46','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Column_ID=74318
;

-- Dec 29, 2014 3:43:57 PM CET
-- LVE- Warehouse Product
UPDATE AD_Column SET IsUpdateable='N',Updated=TO_DATE('2014-12-29 15:43:57','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Column_ID=74290
;

-- Dec 29, 2014 3:44:35 PM CET
-- LVE- Warehouse Product
UPDATE AD_Field SET IsDisplayed='Y', SeqNo=50,Updated=TO_DATE('2014-12-29 15:44:35','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Field_ID=74348
;

-- Dec 29, 2014 3:44:35 PM CET
-- LVE- Warehouse Product
UPDATE AD_Field SET IsDisplayed='Y', SeqNo=60,Updated=TO_DATE('2014-12-29 15:44:35','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Field_ID=74142
;

-- Dec 29, 2014 3:44:35 PM CET
-- LVE- Warehouse Product
UPDATE AD_Field SET IsDisplayed='Y', SeqNo=70,Updated=TO_DATE('2014-12-29 15:44:35','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Field_ID=74161
;

-- Dec 29, 2014 3:44:35 PM CET
-- LVE- Warehouse Product
UPDATE AD_Field SET IsDisplayed='Y', SeqNo=80,Updated=TO_DATE('2014-12-29 15:44:35','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Field_ID=74160
;

-- Dec 29, 2014 3:44:35 PM CET
-- LVE- Warehouse Product
UPDATE AD_Field SET IsDisplayed='Y', SeqNo=90,Updated=TO_DATE('2014-12-29 15:44:35','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Field_ID=74163
;

-- Dec 29, 2014 3:44:35 PM CET
-- LVE- Warehouse Product
UPDATE AD_Field SET IsDisplayed='Y', SeqNo=100,Updated=TO_DATE('2014-12-29 15:44:35','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Field_ID=74162
;

-- Dec 29, 2014 3:44:47 PM CET
-- LVE- Warehouse Product
UPDATE AD_Field SET IsSameLine='Y',Updated=TO_DATE('2014-12-29 15:44:47','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Field_ID=74348
;

-- Dec 29, 2014 3:44:51 PM CET
-- LVE- Warehouse Product
UPDATE AD_Field SET IsSameLine='N',Updated=TO_DATE('2014-12-29 15:44:51','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Field_ID=74142
;

-- Dec 29, 2014 3:45:21 PM CET
-- LVE- Warehouse Product
UPDATE AD_Field SET IsDisplayed='Y', SeqNo=100,Updated=TO_DATE('2014-12-29 15:45:21','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Field_ID=74858
;

-- Dec 29, 2014 3:45:21 PM CET
-- LVE- Warehouse Product
UPDATE AD_Field SET IsDisplayed='Y', SeqNo=110,Updated=TO_DATE('2014-12-29 15:45:21','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Field_ID=74162
;

-- Dec 29, 2014 3:45:41 PM CET
-- LVE- Warehouse Product
UPDATE AD_Field SET IsSameLine='N',Updated=TO_DATE('2014-12-29 15:45:41','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Field_ID=74162
;

-- Dec 29, 2014 3:57:05 PM CET
-- LVE- Warehouse Product
UPDATE AD_Column SET IsMandatory='N',Updated=TO_DATE('2014-12-29 15:57:05','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Column_ID=73852
;

-- Dec 29, 2014 4:06:19 PM CET
-- LVE- Warehouse Product
UPDATE AD_Column SET Callout='org.spin.model.CalloutWarehouseProduct.parentColumn',Updated=TO_DATE('2014-12-29 16:06:19','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Column_ID=74290
;

