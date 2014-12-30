-- Dec 30, 2014 9:12:44 AM CET
-- LVE- Warehouse Product
INSERT INTO AD_Element (AD_Client_ID,AD_Element_ID,AD_Org_ID,AD_Reference_ID,ColumnName,Created,CreatedBy,EntityType,FieldLength,IsActive,Name,PrintName,Updated,UpdatedBy) VALUES (0,57736,0,20,'IsValidToComplete',TO_TIMESTAMP('2014-12-30 09:12:42','YYYY-MM-DD HH24:MI:SS'),100,'ECA02',1,'Y','Valid To Complete','Valid To Complete',TO_TIMESTAMP('2014-12-30 09:12:42','YYYY-MM-DD HH24:MI:SS'),100)
;

-- Dec 30, 2014 9:12:44 AM CET
-- LVE- Warehouse Product
INSERT INTO AD_Element_Trl (AD_Language,AD_Element_ID, Description,Help,Name,PO_Description,PO_Help,PO_Name,PO_PrintName,PrintName, IsTranslated,AD_Client_ID,AD_Org_ID,Created,Createdby,Updated,UpdatedBy) SELECT l.AD_Language,t.AD_Element_ID, t.Description,t.Help,t.Name,t.PO_Description,t.PO_Help,t.PO_Name,t.PO_PrintName,t.PrintName, 'N',t.AD_Client_ID,t.AD_Org_ID,t.Created,t.Createdby,t.Updated,t.UpdatedBy FROM AD_Language l, AD_Element t WHERE l.IsActive='Y' AND l.IsSystemLanguage='Y' AND l.IsBaseLanguage='N' AND t.AD_Element_ID=57736 AND NOT EXISTS (SELECT * FROM AD_Element_Trl tt WHERE tt.AD_Language=l.AD_Language AND tt.AD_Element_ID=t.AD_Element_ID)
;

-- Dec 30, 2014 9:12:56 AM CET
-- LVE- Warehouse Product
UPDATE AD_Element_Trl SET Name='Validar al Completar',PrintName='Validar al Completar',Updated=TO_TIMESTAMP('2014-12-30 09:12:56','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Element_ID=57736 AND AD_Language='es_MX'
;

-- Dec 30, 2014 9:13:04 AM CET
-- LVE- Warehouse Product
UPDATE AD_Element SET Name='Valid to Complete', PrintName='Valid to Complete',Updated=TO_TIMESTAMP('2014-12-30 09:13:04','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Element_ID=57736
;

-- Dec 30, 2014 9:13:04 AM CET
-- LVE- Warehouse Product
UPDATE AD_Element_Trl SET IsTranslated='N' WHERE AD_Element_ID=57736
;

-- Dec 30, 2014 9:13:04 AM CET
-- LVE- Warehouse Product
UPDATE AD_Column SET ColumnName='IsValidToComplete', Name='Valid to Complete', Description=NULL, Help=NULL WHERE AD_Element_ID=57736
;

-- Dec 30, 2014 9:13:04 AM CET
-- LVE- Warehouse Product
UPDATE AD_Process_Para SET ColumnName='IsValidToComplete', Name='Valid to Complete', Description=NULL, Help=NULL, AD_Element_ID=57736 WHERE UPPER(ColumnName)='ISVALIDTOCOMPLETE' AND IsCentrallyMaintained='Y' AND AD_Element_ID IS NULL
;

-- Dec 30, 2014 9:13:04 AM CET
-- LVE- Warehouse Product
UPDATE AD_Process_Para SET ColumnName='IsValidToComplete', Name='Valid to Complete', Description=NULL, Help=NULL WHERE AD_Element_ID=57736 AND IsCentrallyMaintained='Y'
;

-- Dec 30, 2014 9:13:04 AM CET
-- LVE- Warehouse Product
UPDATE AD_Field SET Name='Valid to Complete', Description=NULL, Help=NULL WHERE AD_Column_ID IN (SELECT AD_Column_ID FROM AD_Column WHERE AD_Element_ID=57736) AND IsCentrallyMaintained='Y'
;

-- Dec 30, 2014 9:13:04 AM CET
-- LVE- Warehouse Product
UPDATE AD_PrintFormatItem SET PrintName='Valid to Complete', Name='Valid to Complete' WHERE IsCentrallyMaintained='Y' AND EXISTS (SELECT * FROM AD_Column c WHERE c.AD_Column_ID=AD_PrintFormatItem.AD_Column_ID AND c.AD_Element_ID=57736)
;

-- Dec 30, 2014 9:13:39 AM CET
-- LVE- Warehouse Product
INSERT INTO AD_Column (AD_Client_ID,AD_Column_ID,AD_Element_ID,AD_Org_ID,AD_Reference_ID,AD_Table_ID,ColumnName,Created,CreatedBy,DefaultValue,EntityType,FieldLength,IsActive,IsAllowLogging,IsAlwaysUpdateable,IsAutocomplete,IsEncrypted,IsIdentifier,IsKey,IsMandatory,IsParent,IsSelectionColumn,IsSyncDatabase,IsTranslated,IsUpdateable,Name,SeqNo,Updated,UpdatedBy,Version) VALUES (0,75307,57736,0,20,53847,'IsValidToComplete',TO_TIMESTAMP('2014-12-30 09:13:38','YYYY-MM-DD HH24:MI:SS'),100,'N','ECA02',1,'Y','Y','N','N','N','N','N','N','N','N','N','N','Y','Valid to Complete',0,TO_TIMESTAMP('2014-12-30 09:13:38','YYYY-MM-DD HH24:MI:SS'),100,0)
;

-- Dec 30, 2014 9:13:39 AM CET
-- LVE- Warehouse Product
INSERT INTO AD_Column_Trl (AD_Language,AD_Column_ID, Name, IsTranslated,AD_Client_ID,AD_Org_ID,Created,Createdby,Updated,UpdatedBy) SELECT l.AD_Language,t.AD_Column_ID, t.Name, 'N',t.AD_Client_ID,t.AD_Org_ID,t.Created,t.Createdby,t.Updated,t.UpdatedBy FROM AD_Language l, AD_Column t WHERE l.IsActive='Y' AND l.IsSystemLanguage='Y' AND l.IsBaseLanguage='N' AND t.AD_Column_ID=75307 AND NOT EXISTS (SELECT * FROM AD_Column_Trl tt WHERE tt.AD_Language=l.AD_Language AND tt.AD_Column_ID=t.AD_Column_ID)
;

-- Dec 30, 2014 9:14:37 AM CET
-- LVE- Warehouse Product
INSERT INTO AD_Field (AD_Client_ID,AD_Column_ID,AD_Field_ID,AD_Org_ID,AD_Tab_ID,Created,CreatedBy,DisplayLength,EntityType,HideInListView,IsActive,IsCentrallyMaintained,IsDisplayed,IsEncrypted,IsFieldOnly,IsHeading,IsReadOnly,IsSameLine,Name,PreferredWidth,SeqNo,SortNo,Updated,UpdatedBy) VALUES (0,75307,75052,0,53987,TO_TIMESTAMP('2014-12-30 09:14:37','YYYY-MM-DD HH24:MI:SS'),100,0,'ECA02','N','Y','Y','Y','N','N','N','N','N','Valid to Complete',0,140,0,TO_TIMESTAMP('2014-12-30 09:14:37','YYYY-MM-DD HH24:MI:SS'),100)
;

-- Dec 30, 2014 9:14:37 AM CET
-- LVE- Warehouse Product
INSERT INTO AD_Field_Trl (AD_Language,AD_Field_ID, Description,Help,Name, IsTranslated,AD_Client_ID,AD_Org_ID,Created,Createdby,Updated,UpdatedBy) SELECT l.AD_Language,t.AD_Field_ID, t.Description,t.Help,t.Name, 'N',t.AD_Client_ID,t.AD_Org_ID,t.Created,t.Createdby,t.Updated,t.UpdatedBy FROM AD_Language l, AD_Field t WHERE l.IsActive='Y' AND l.IsSystemLanguage='Y' AND l.IsBaseLanguage='N' AND t.AD_Field_ID=75052 AND NOT EXISTS (SELECT * FROM AD_Field_Trl tt WHERE tt.AD_Language=l.AD_Language AND tt.AD_Field_ID=t.AD_Field_ID)
;

-- Dec 30, 2014 9:15:03 AM CET
-- LVE- Warehouse Product
UPDATE AD_Field SET IsDisplayed='Y', SeqNo=70,Updated=TO_TIMESTAMP('2014-12-30 09:15:03','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Field_ID=75052
;

-- Dec 30, 2014 9:15:03 AM CET
-- LVE- Warehouse Product
UPDATE AD_Field SET IsDisplayed='Y', SeqNo=80,Updated=TO_TIMESTAMP('2014-12-30 09:15:03','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Field_ID=74161
;

-- Dec 30, 2014 9:15:04 AM CET
-- LVE- Warehouse Product
UPDATE AD_Field SET IsDisplayed='Y', SeqNo=90,Updated=TO_TIMESTAMP('2014-12-30 09:15:04','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Field_ID=74160
;

-- Dec 30, 2014 9:15:04 AM CET
-- LVE- Warehouse Product
UPDATE AD_Field SET IsDisplayed='Y', SeqNo=100,Updated=TO_TIMESTAMP('2014-12-30 09:15:04','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Field_ID=74163
;

-- Dec 30, 2014 9:15:04 AM CET
-- LVE- Warehouse Product
UPDATE AD_Field SET IsDisplayed='Y', SeqNo=110,Updated=TO_TIMESTAMP('2014-12-30 09:15:04','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Field_ID=74858
;

-- Dec 30, 2014 9:15:04 AM CET
-- LVE- Warehouse Product
UPDATE AD_Field SET IsDisplayed='Y', SeqNo=120,Updated=TO_TIMESTAMP('2014-12-30 09:15:04','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Field_ID=74162
;

-- Dec 30, 2014 9:15:04 AM CET
-- LVE- Warehouse Product
UPDATE AD_Field SET IsDisplayed='Y', SeqNo=130,Updated=TO_TIMESTAMP('2014-12-30 09:15:04','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Field_ID=74287
;

-- Dec 30, 2014 9:15:04 AM CET
-- LVE- Warehouse Product
UPDATE AD_Field SET IsDisplayed='Y', SeqNo=140,Updated=TO_TIMESTAMP('2014-12-30 09:15:04','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Field_ID=74146
;

-- Dec 30, 2014 9:15:11 AM CET
-- LVE- Warehouse Product
UPDATE AD_Field SET IsSameLine='Y',Updated=TO_TIMESTAMP('2014-12-30 09:15:11','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Field_ID=75052
;

