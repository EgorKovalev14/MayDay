package ru.timcock.mayday.presentation;

import android.content.Context;
import android.content.Intent;

public class Builder {
    public static Builder getInstance(Context context) {
        return new Builder(context);
    }

    public Builder(Context context) {
        this.mContext = context;
    }

    public Builder setMessage(String message) {
        this.mMessage = message;
        return this;
    }

    public Builder setCommand(@Command int command) {
        this.mCommandId = command;
        return this;
    }

    public Intent build() {
        Intent intent = new Intent(mContext, MyTileService.class);
        if (mCommandId != Command.INVALID) {
            intent.putExtra(KEY_COMMAND, mCommandId);
        }
        if (mMessage != null) {
            intent.putExtra(KEY_MESSAGE, mMessage);
        }
        return intent;
    }
}
