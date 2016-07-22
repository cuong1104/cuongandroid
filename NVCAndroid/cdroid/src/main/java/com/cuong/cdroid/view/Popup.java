package com.cuong.cdroid.view;

import android.content.Context;
import android.os.Handler;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;

/**
 * Created by vcuon on 11/24/2015.
 * Open Source: This source has been wrote by CuongNguyen
 * Contact: vcuong11s@gmail.com or unme.rf@gmail.com
 */
public class Popup {
    /**
     * Popup will close when activity close
     */
    private PopupWindow popUp;
    private PopupParams params;

    public static class PopupParams {
        public Context context;
        public View layout;
        public View vClose;
        public View vContent;
        public int idClose;
        public int idContent;
        private OnDialogClose onDialogClose;

        public PopupParams(Context context) {
            this.context = context;
        }
    }

    public static class Builder {
        private final PopupParams P;

        public Builder(Context context) {
            P = new PopupParams(context);
        }

        public Builder customView(View view) {
            P.layout = view;
            if (P.layout == null) {
                throw new RuntimeException("Error, custom view is null");
            }
            return this;
        }

        public Builder customView(int id) {
            P.layout = LayoutInflater.from(P.context).inflate(id, null, false);
            if (P.layout == null) {
                throw new RuntimeException("Cannot find custom view with id " + id);
            }
            return this;
        }

        public Builder contentView(View view) {
            P.vContent = view;
            return this;
        }

        public Builder contentView(int idContent) {
            P.idContent = idContent;
            if (P.layout != null && idContent != 0) {
                P.vContent = P.layout.findViewById(idContent);
            }
            return this;
        }

        public Builder closeView(int idClose) {
            P.idClose = idClose;
            if (P.layout != null && idClose != 0) {
                P.vClose = P.layout.findViewById(idClose);
            }
            return this;
        }

        public Builder closeView(View view) {
            P.vClose = view;
            return this;
        }

        public Builder onClose(OnDialogClose onClose) {
            P.onDialogClose = onClose;
            return this;
        }

        public Popup build() {
            return new Popup(P);
        }
    }

    public Popup(PopupParams params) {
        this.params = params;
        popUp = new PopupWindow(params.layout, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT, true);

        if (Popup.this.params.layout != null) {
            Popup.this.params.layout.setClickable(true);
        } else {
            throw new RuntimeException("PopupLayout is null");
        }

        if (params.vClose != null) {
            params.vClose.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    dismiss();
                }
            });
        }
        popUp.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                if (Popup.this.params.onDialogClose != null) {
                    Popup.this.params.onDialogClose.onClose();
                }
            }
        });
    }

    public void show() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (!popUp.isShowing()) {
                    popUp.showAtLocation(params.layout, Gravity.CENTER, 0, 0);
                }
            }
        }, 200);
    }

    public void dismiss() {
        if (popUp != null && popUp.isShowing()) {
            popUp.dismiss();
        } else {
            Log.d("Popup", "Error, popup isn't init or not showing.");
        }
    }

    public void refresh() {
        if (popUp.isShowing()) {
            popUp.update();
        }
    }

    public boolean isShowing() {
        return popUp.isShowing();
    }

    public void setCancelable(boolean flag) {
        popUp.setOutsideTouchable(flag);
        if (params.layout != null && flag) {
            params.layout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dismiss();
                }
            });
        }
    }

    public void setOnDialogClose(OnDialogClose onDialogClose) {
        params.onDialogClose = onDialogClose;
    }

    public Context getContext() {
        return params.context;
    }

    public interface OnDialogClose {
        void onClose();
    }
}
