#cuongandroid
Android library with many future
##1, CustomDialog
A custom dialog library very easy to use. It like a fragment or activity... You can do anything you want
###How to use
    CustomDialog dialog = new CustomDialog(context);
    dialog.initDialog(mView, R.id.ivClose, R.id.vContent);

With:

* mView: A view(may Inflater from layout), you can add event for the    compoment on this layout. 
* R.id.ivClose: Id of comoment on mView, use    to close dialog (like close button, etc...). You can put 0 at this.    
* R.id.vContent: Id of content view. You can put 0 at this.

Call: `dialog.show()`
To show dialog.

Call: `dialog.dismiss()`
To close dialog.

And more ...
