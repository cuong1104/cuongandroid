#cuongandroid
Android library with many future

##1, CustomDialog

A custom dialog library very easy to use. It like a fragment or activity... You can do anything you want

###How to use

CustomDialog dialog = new CustomDialog(context);

dialog.initDialog(mView, R.id.ivClose, R.id.vContent);

With:

mView: A view(may Inflater from layout), you can add event for the compoment on this layout.
R.id.ivClose: Id of comoment on mView, use to close dialog (like close button, etc...). You can put 0 at this.
R.id.vContent: Id of content view. You can put 0 at this.
Call: dialog.show()

To show dialog.

Call: dialog.dismiss()

To close dialog.

And more ...

##2, SMS/MMS Backup/Restore

Allow you backup and restore all SMS and MMS in android device. Also, you can delete all SMS or MMS.

Some diffrent future like backup from time, you can choose where to save file backup.

###How to use

1, Get all SMS and MMS

ArrayList<SMSEntity> listSms = SMSUtils.getAllSms(context);

ArrayList<MMSEntity> listMms = SMSUtils.getAllSmsBefore(context, calender.getTimeInMillis());

ArrayList<MMSEntity> listMms = MMSUtils.getAllMms(context);

2, Set ProgressBar and TextView

XmlUtils.pbBackup = pbBackup;

XmlUtils.tvBackup = tvProgressBackup;

You can edit if not want to use.

3, Set Path save

Bydefault, it will create a folder smsbackup automatical. You can change by:

XmlUtils.pathSave = Environment.getExternalStorageDirectory()+ File.separator + "SMSBackup";

3, Set On Backup Finish

XmlUtils.OnFinishBackup finish = new XmlUtils.OnFinishBackup() { @Override public void onFinish() { DeviceUtils.showMessage(context, "Backup completed!"); } }; XmlUtils.BackupSMS(fileName, listSms, listMms, finish);

4, Restore

Set ProgressBar: XmlUtils.pbRestore = pbRestore;

Set Button Restore: XmlUtils.btnRestore = btnRestore; need to lock it while restoring

Set TextView: XmlUtils.tvProgressRestore = tvProgressRestore; to show progress ex: 12/222

Restore: XmlUtils.RestoreSMS(context, pathBackup, merger);
