package de.florianisme.wakeonlan.ui.modify.watcher.validator;

import android.widget.EditText;

import com.google.common.base.Strings;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

import de.florianisme.wakeonlan.R;

public class SecureOnPasswordValidator extends Validator {

    private static final Charset CHARSET = StandardCharsets.US_ASCII;

    public SecureOnPasswordValidator(EditText editTextView) {
        super(editTextView);
    }

    @Override
    ValidationResult validate(String text) {
        int passwordBytesLength = Strings.nullToEmpty(text).getBytes(CHARSET).length;

        if (passwordBytesLength == 4 || passwordBytesLength == 6) {
            return ValidationResult.VALID;
        }

        return ValidationResult.INVALID;
    }

    @Override
    int getErrorMessageStringId() {
        return R.string.add_device_error_secure_on_password_invalid;
    }
}
