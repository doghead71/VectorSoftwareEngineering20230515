package com.jamteach.testapp.preference;

import android.content.Context;
import android.database.Cursor;
import android.media.RingtoneManager;
import android.net.Uri;
import android.util.AttributeSet;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.preference.ListPreference;

import java.util.Map;
import java.util.TreeMap;

public class CustomRingtonePreference extends ListPreference {
    private Context _context;
    public CustomRingtonePreference(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        setupDialog(context);
    }

    private void setupDialog(@NonNull Context context) {
        _context = context;
        Map<String, Uri> _ringtones = getRingtones();
        CharSequence [] ringtoneKeys = new CharSequence[_ringtones.size()];
        CharSequence [] ringtoneValues = new CharSequence[_ringtones.size()];
        _ringtones.keySet().toArray(ringtoneKeys);
        this.setEntries(ringtoneKeys);
        this.setEntryValues(ringtoneKeys);
    }

    public CustomRingtonePreference(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setupDialog(context);
    }

    public CustomRingtonePreference(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        setupDialog(context);
    }

    public CustomRingtonePreference(@NonNull Context context) {
        super(context);
        setupDialog(context);
    }

    private Map<String, Uri> getRingtones(){
        Map<String, Uri> ringtones = new TreeMap<>();

        RingtoneManager ringtoneManager = new RingtoneManager(_context);
        ringtoneManager.setType(RingtoneManager.TYPE_ALL);
        Cursor ringtoneCursor = ringtoneManager.getCursor();

        while(ringtoneCursor.moveToNext()){
           Uri ringtoneUri = ringtoneManager.getRingtoneUri(ringtoneCursor.getPosition());
           String ringtoneTitle = ringtoneCursor.getString(RingtoneManager.TITLE_COLUMN_INDEX);

           ringtones.put(ringtoneTitle, ringtoneUri);
        }

        return ringtones;
    }


}
