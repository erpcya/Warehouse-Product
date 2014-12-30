-- Dec 30, 2014 11:12:21 PM CET
-- LVE- Warehouse Product
INSERT INTO AD_Column (AD_Client_ID,AD_Column_ID,AD_Element_ID,AD_Org_ID,AD_Reference_ID,AD_Table_ID,ColumnName,Created,CreatedBy,Description,EntityType,FieldLength,Help,IsActive,IsAllowLogging,IsAlwaysUpdateable,IsAutocomplete,IsEncrypted,IsIdentifier,IsKey,IsMandatory,IsParent,IsSelectionColumn,IsSyncDatabase,IsTranslated,IsUpdateable,Name,SeqNo,Updated,UpdatedBy,Version) VALUES (0,75393,448,0,19,53848,'M_Locator_ID',TO_DATE('2014-12-30 23:12:11','YYYY-MM-DD HH24:MI:SS'),100,'Warehouse Locator','ECA02',22,'The Locator indicates where in a Warehouse a product is located.','Y','Y','N','N','N','N','N','N','N','N','N','N','N','Locator',0,TO_DATE('2014-12-30 23:12:11','YYYY-MM-DD HH24:MI:SS'),100,0)
;

-- Dec 30, 2014 11:12:21 PM CET
-- LVE- Warehouse Product
INSERT INTO AD_Column_Trl (AD_Language,AD_Column_ID, Name, IsTranslated,AD_Client_ID,AD_Org_ID,Created,Createdby,Updated,UpdatedBy) SELECT l.AD_Language,t.AD_Column_ID, t.Name, 'N',t.AD_Client_ID,t.AD_Org_ID,t.Created,t.Createdby,t.Updated,t.UpdatedBy FROM AD_Language l, AD_Column t WHERE l.IsActive='Y' AND l.IsSystemLanguage='Y' AND l.IsBaseLanguage='N' AND t.AD_Column_ID=75393 AND NOT EXISTS (SELECT * FROM AD_Column_Trl tt WHERE tt.AD_Language=l.AD_Language AND tt.AD_Column_ID=t.AD_Column_ID)
;

-- Dec 30, 2014 11:13:39 PM CET
-- LVE- Warehouse Product
UPDATE AD_Column SET AD_Val_Rule_ID=127,Updated=TO_DATE('2014-12-30 23:13:39','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Column_ID=75393
;

-- Dec 30, 2014 11:15:31 PM CET
-- LVE- Warehouse Product
UPDATE AD_Column SET IsMandatory='N',Updated=TO_DATE('2014-12-30 23:15:31','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Column_ID=73843
;

-- Dec 30, 2014 11:15:56 PM CET
-- LVE- Warehouse Product
UPDATE AD_Column SET IsIdentifier='Y', SeqNo=4,Updated=TO_DATE('2014-12-30 23:15:56','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Column_ID=75393
;

-- Dec 30, 2014 11:17:29 PM CET
-- LVE- Warehouse Product
INSERT INTO AD_Field (AD_Client_ID,AD_Column_ID,AD_Field_ID,AD_Org_ID,AD_Tab_ID,Created,CreatedBy,Description,DisplayLength,EntityType,Help,HideInListView,IsActive,IsCentrallyMaintained,IsDisplayed,IsEncrypted,IsFieldOnly,IsHeading,IsReadOnly,IsSameLine,Name,PreferredWidth,SeqNo,SortNo,Updated,UpdatedBy) VALUES (0,75393,75053,0,53988,TO_DATE('2014-12-30 23:17:27','YYYY-MM-DD HH24:MI:SS'),100,'Warehouse Locator',0,'ECA02','The Locator indicates where in a Warehouse a product is located.','N','Y','Y','Y','N','N','N','N','N','Locator',0,120,0,TO_DATE('2014-12-30 23:17:27','YYYY-MM-DD HH24:MI:SS'),100)
;

-- Dec 30, 2014 11:17:29 PM CET
-- LVE- Warehouse Product
INSERT INTO AD_Field_Trl (AD_Language,AD_Field_ID, Description,Help,Name, IsTranslated,AD_Client_ID,AD_Org_ID,Created,Createdby,Updated,UpdatedBy) SELECT l.AD_Language,t.AD_Field_ID, t.Description,t.Help,t.Name, 'N',t.AD_Client_ID,t.AD_Org_ID,t.Created,t.Createdby,t.Updated,t.UpdatedBy FROM AD_Language l, AD_Field t WHERE l.IsActive='Y' AND l.IsSystemLanguage='Y' AND l.IsBaseLanguage='N' AND t.AD_Field_ID=75053 AND NOT EXISTS (SELECT * FROM AD_Field_Trl tt WHERE tt.AD_Language=l.AD_Language AND tt.AD_Field_ID=t.AD_Field_ID)
;

-- Dec 30, 2014 11:19:30 PM CET
-- LVE- Warehouse Product
UPDATE AD_Field SET IsDisplayed='Y', SeqNo=70,Updated=TO_DATE('2014-12-30 23:19:30','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Field_ID=75053
;

-- Dec 30, 2014 11:19:30 PM CET
-- LVE- Warehouse Product
UPDATE AD_Field SET IsDisplayed='Y', SeqNo=80,Updated=TO_DATE('2014-12-30 23:19:30','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Field_ID=74151
;

-- Dec 30, 2014 11:19:30 PM CET
-- LVE- Warehouse Product
UPDATE AD_Field SET IsDisplayed='Y', SeqNo=90,Updated=TO_DATE('2014-12-30 23:19:30','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Field_ID=75051
;

-- Dec 30, 2014 11:19:30 PM CET
-- LVE- Warehouse Product
UPDATE AD_Field SET IsDisplayed='Y', SeqNo=100,Updated=TO_DATE('2014-12-30 23:19:30','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Field_ID=74152
;

-- Dec 30, 2014 11:19:30 PM CET
-- LVE- Warehouse Product
UPDATE AD_Field SET IsDisplayed='Y', SeqNo=110,Updated=TO_DATE('2014-12-30 23:19:30','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Field_ID=74155
;

-- Dec 30, 2014 11:19:30 PM CET
-- LVE- Warehouse Product
UPDATE AD_Field SET IsDisplayed='Y', SeqNo=120,Updated=TO_DATE('2014-12-30 23:19:30','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Field_ID=74156
;

-- Dec 30, 2014 11:19:38 PM CET
-- LVE- Warehouse Product
UPDATE AD_Field SET IsSameLine='N',Updated=TO_DATE('2014-12-30 23:19:38','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Field_ID=74157
;

-- Dec 30, 2014 11:19:42 PM CET
-- LVE- Warehouse Product
UPDATE AD_Field SET IsSameLine='Y',Updated=TO_DATE('2014-12-30 23:19:42','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Field_ID=75053
;

