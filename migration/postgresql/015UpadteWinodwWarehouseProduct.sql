-- Nov 20, 2014 10:20:40 AM VET
-- Warehouse Product
INSERT INTO AD_Field (AD_Client_ID,AD_Column_ID,AD_Field_ID,AD_Org_ID,AD_Tab_ID,Created,CreatedBy,DisplayLength,EntityType,IsActive,IsCentrallyMaintained,IsDisplayed,IsEncrypted,IsFieldOnly,IsHeading,IsReadOnly,IsSameLine,Name,Updated,UpdatedBy) VALUES (0,74318,74858,0,53987,TO_TIMESTAMP('2014-11-20 10:20:36','YYYY-MM-DD HH24:MI:SS'),100,10,'ECA02','Y','Y','Y','N','N','N','N','N','Locator Column',TO_TIMESTAMP('2014-11-20 10:20:36','YYYY-MM-DD HH24:MI:SS'),100)
;

-- Nov 20, 2014 10:20:40 AM VET
-- Warehouse Product
INSERT INTO AD_Field_Trl (AD_Language,AD_Field_ID, Description,Help,Name, IsTranslated,AD_Client_ID,AD_Org_ID,Created,Createdby,Updated,UpdatedBy) SELECT l.AD_Language,t.AD_Field_ID, t.Description,t.Help,t.Name, 'N',t.AD_Client_ID,t.AD_Org_ID,t.Created,t.Createdby,t.Updated,t.UpdatedBy FROM AD_Language l, AD_Field t WHERE l.IsActive='Y' AND l.IsSystemLanguage='Y' AND l.IsBaseLanguage='N' AND t.AD_Field_ID=74858 AND NOT EXISTS (SELECT * FROM AD_Field_Trl tt WHERE tt.AD_Language=l.AD_Language AND tt.AD_Field_ID=t.AD_Field_ID)
;

-- Nov 20, 2014 10:30:18 AM VET
-- Warehouse Product
UPDATE AD_Column SET DefaultValue='@SQL=SELECT COALESCE(MAX(SeqNo),0)+10 AS DefaultValue FROM LVE_WarehouseProductLine WHERE LVE_WarehouseProductLine_ID=@LVE_WarehouseProductLine_ID@',Updated=TO_TIMESTAMP('2014-11-20 10:30:18','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Column_ID=73844
;

-- Nov 20, 2014 10:36:32 AM VET
-- Warehouse Product
UPDATE AD_Column SET DefaultValue=NULL,Updated=TO_TIMESTAMP('2014-11-20 10:36:32','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Column_ID=73844
;

-- Nov 20, 2014 10:43:28 AM VET
-- Warehouse Product
UPDATE AD_Field SET IsDisplayed='Y', SeqNo=110,Updated=TO_TIMESTAMP('2014-11-20 10:43:28','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Field_ID=74858
;

-- Nov 20, 2014 10:43:29 AM VET
-- Warehouse Product
UPDATE AD_Field SET IsDisplayed='Y', SeqNo=120,Updated=TO_TIMESTAMP('2014-11-20 10:43:29','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Field_ID=74287
;

-- Nov 20, 2014 10:43:29 AM VET
-- Warehouse Product
UPDATE AD_Field SET IsDisplayed='Y', SeqNo=130,Updated=TO_TIMESTAMP('2014-11-20 10:43:29','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Field_ID=74146
;

-- Nov 20, 2014 10:43:36 AM VET
-- Warehouse Product
UPDATE AD_Field SET IsSameLine='Y',Updated=TO_TIMESTAMP('2014-11-20 10:43:36','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Field_ID=74858
;

-- Nov 20, 2014 10:43:52 AM VET
-- Warehouse Product
UPDATE AD_Field SET IsReadOnly='Y',Updated=TO_TIMESTAMP('2014-11-20 10:43:52','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Field_ID=74143
;

