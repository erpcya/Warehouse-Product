-- Dec 29, 2014 4:24:54 PM CET
-- LVE- Warehouse Product
INSERT INTO AD_Element (AD_Client_ID,AD_Element_ID,AD_Org_ID,AD_Reference_ID,ColumnName,Created,CreatedBy,EntityType,FieldLength,IsActive,Name,PrintName,Updated,UpdatedBy) VALUES (0,57735,0,20,'IsSetWarehouse',TO_DATE('2014-12-29 16:24:53','YYYY-MM-DD HH24:MI:SS'),100,'ECA02',1,'Y','Is Set Warehouse','Is Set Warehouse',TO_DATE('2014-12-29 16:24:53','YYYY-MM-DD HH24:MI:SS'),100)
;

-- Dec 29, 2014 4:24:54 PM CET
-- LVE- Warehouse Product
INSERT INTO AD_Element_Trl (AD_Language,AD_Element_ID, Description,Help,Name,PO_Description,PO_Help,PO_Name,PO_PrintName,PrintName, IsTranslated,AD_Client_ID,AD_Org_ID,Created,Createdby,Updated,UpdatedBy) SELECT l.AD_Language,t.AD_Element_ID, t.Description,t.Help,t.Name,t.PO_Description,t.PO_Help,t.PO_Name,t.PO_PrintName,t.PrintName, 'N',t.AD_Client_ID,t.AD_Org_ID,t.Created,t.Createdby,t.Updated,t.UpdatedBy FROM AD_Language l, AD_Element t WHERE l.IsActive='Y' AND l.IsSystemLanguage='Y' AND l.IsBaseLanguage='N' AND t.AD_Element_ID=57735 AND NOT EXISTS (SELECT * FROM AD_Element_Trl tt WHERE tt.AD_Language=l.AD_Language AND tt.AD_Element_ID=t.AD_Element_ID)
;

-- Dec 29, 2014 4:25:11 PM CET
-- LVE- Warehouse Product
UPDATE AD_Element_Trl SET Name='Establece el Almacén',PrintName='Establece el Almacén',Updated=TO_DATE('2014-12-29 16:25:11','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Element_ID=57735 AND AD_Language='es_MX'
;

-- Dec 29, 2014 4:26:05 PM CET
-- LVE- Warehouse Product
INSERT INTO AD_Column (AD_Client_ID,AD_Column_ID,AD_Element_ID,AD_Org_ID,AD_Reference_ID,AD_Table_ID,ColumnName,Created,CreatedBy,DefaultValue,EntityType,FieldLength,IsActive,IsAllowLogging,IsAlwaysUpdateable,IsAutocomplete,IsEncrypted,IsIdentifier,IsKey,IsMandatory,IsParent,IsSelectionColumn,IsSyncDatabase,IsTranslated,IsUpdateable,Name,SeqNo,Updated,UpdatedBy,Version) VALUES (0,75305,57735,0,20,53848,'IsSetWarehouse',TO_DATE('2014-12-29 16:26:04','YYYY-MM-DD HH24:MI:SS'),100,'N','ECA02',1,'Y','Y','N','N','N','N','N','N','N','N','N','N','Y','Is Set Warehouse',0,TO_DATE('2014-12-29 16:26:04','YYYY-MM-DD HH24:MI:SS'),100,0)
;

-- Dec 29, 2014 4:26:05 PM CET
-- LVE- Warehouse Product
INSERT INTO AD_Column_Trl (AD_Language,AD_Column_ID, Name, IsTranslated,AD_Client_ID,AD_Org_ID,Created,Createdby,Updated,UpdatedBy) SELECT l.AD_Language,t.AD_Column_ID, t.Name, 'N',t.AD_Client_ID,t.AD_Org_ID,t.Created,t.Createdby,t.Updated,t.UpdatedBy FROM AD_Language l, AD_Column t WHERE l.IsActive='Y' AND l.IsSystemLanguage='Y' AND l.IsBaseLanguage='N' AND t.AD_Column_ID=75305 AND NOT EXISTS (SELECT * FROM AD_Column_Trl tt WHERE tt.AD_Language=l.AD_Language AND tt.AD_Column_ID=t.AD_Column_ID)
;

-- Dec 29, 2014 4:27:51 PM CET
-- LVE- Warehouse Product
INSERT INTO AD_Field (AD_Client_ID,AD_Column_ID,AD_Field_ID,AD_Org_ID,AD_Tab_ID,Created,CreatedBy,DisplayLength,EntityType,HideInListView,IsActive,IsCentrallyMaintained,IsDisplayed,IsEncrypted,IsFieldOnly,IsHeading,IsReadOnly,IsSameLine,Name,PreferredWidth,SeqNo,SortNo,Updated,UpdatedBy) VALUES (0,75305,75051,0,53988,TO_DATE('2014-12-29 16:27:50','YYYY-MM-DD HH24:MI:SS'),100,0,'ECA02','N','Y','Y','Y','N','N','N','N','N','Is Set Warehouse',0,110,0,TO_DATE('2014-12-29 16:27:50','YYYY-MM-DD HH24:MI:SS'),100)
;

-- Dec 29, 2014 4:27:51 PM CET
-- LVE- Warehouse Product
INSERT INTO AD_Field_Trl (AD_Language,AD_Field_ID, Description,Help,Name, IsTranslated,AD_Client_ID,AD_Org_ID,Created,Createdby,Updated,UpdatedBy) SELECT l.AD_Language,t.AD_Field_ID, t.Description,t.Help,t.Name, 'N',t.AD_Client_ID,t.AD_Org_ID,t.Created,t.Createdby,t.Updated,t.UpdatedBy FROM AD_Language l, AD_Field t WHERE l.IsActive='Y' AND l.IsSystemLanguage='Y' AND l.IsBaseLanguage='N' AND t.AD_Field_ID=75051 AND NOT EXISTS (SELECT * FROM AD_Field_Trl tt WHERE tt.AD_Language=l.AD_Language AND tt.AD_Field_ID=t.AD_Field_ID)
;

-- Dec 29, 2014 4:28:25 PM CET
-- LVE- Warehouse Product
UPDATE AD_Field SET DisplayLogic='@IsSetWarehouse@=''Y''',Updated=TO_DATE('2014-12-29 16:28:25','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Field_ID=74152
;

-- Dec 29, 2014 4:28:59 PM CET
-- LVE- Warehouse Product
UPDATE AD_Field SET IsDisplayed='Y', SeqNo=50,Updated=TO_DATE('2014-12-29 16:28:59','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Field_ID=74154
;

-- Dec 29, 2014 4:28:59 PM CET
-- LVE- Warehouse Product
UPDATE AD_Field SET IsDisplayed='Y', SeqNo=60,Updated=TO_DATE('2014-12-29 16:28:59','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Field_ID=74157
;

-- Dec 29, 2014 4:28:59 PM CET
-- LVE- Warehouse Product
UPDATE AD_Field SET IsDisplayed='Y', SeqNo=80,Updated=TO_DATE('2014-12-29 16:28:59','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Field_ID=75051
;

-- Dec 29, 2014 4:28:59 PM CET
-- LVE- Warehouse Product
UPDATE AD_Field SET IsDisplayed='Y', SeqNo=110,Updated=TO_DATE('2014-12-29 16:28:59','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Field_ID=74156
;

-- Dec 29, 2014 4:29:04 PM CET
-- LVE- Warehouse Product
UPDATE AD_Field SET IsSameLine='N',Updated=TO_DATE('2014-12-29 16:29:04','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Field_ID=74154
;

-- Dec 29, 2014 4:29:07 PM CET
-- LVE- Warehouse Product
UPDATE AD_Field SET IsSameLine='Y',Updated=TO_DATE('2014-12-29 16:29:07','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Field_ID=74157
;

-- Dec 29, 2014 4:29:15 PM CET
-- LVE- Warehouse Product
UPDATE AD_Field SET IsSameLine='Y',Updated=TO_DATE('2014-12-29 16:29:15','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Field_ID=74152
;

-- Dec 29, 2014 4:29:19 PM CET
-- LVE- Warehouse Product
UPDATE AD_Field SET IsSameLine='N',Updated=TO_DATE('2014-12-29 16:29:19','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Field_ID=74155
;

-- Dec 29, 2014 4:29:23 PM CET
-- LVE- Warehouse Product
UPDATE AD_Field SET IsSameLine='Y',Updated=TO_DATE('2014-12-29 16:29:23','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Field_ID=74156
;

