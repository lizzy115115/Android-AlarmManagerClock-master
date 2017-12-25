package com.zes.greendao.gen;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

import com.loonggg.alarmmanager.clock.bean.Alarm;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "ALARM".
*/
public class AlarmDao extends AbstractDao<Alarm, Long> {

    public static final String TABLENAME = "ALARM";

    /**
     * Properties of entity Alarm.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property AlarmTime = new Property(1, String.class, "alarmTime", false, "ALARM_TIME");
        public final static Property AlarmType = new Property(2, int.class, "alarmType", false, "ALARM_TYPE");
        public final static Property AlarmTypeName = new Property(3, String.class, "alarmTypeName", false, "ALARM_TYPE_NAME");
        public final static Property IsOpen = new Property(4, boolean.class, "isOpen", false, "IS_OPEN");
    };


    public AlarmDao(DaoConfig config) {
        super(config);
    }
    
    public AlarmDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"ALARM\" (" + //
                "\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT ," + // 0: id
                "\"ALARM_TIME\" TEXT," + // 1: alarmTime
                "\"ALARM_TYPE\" INTEGER NOT NULL ," + // 2: alarmType
                "\"ALARM_TYPE_NAME\" TEXT," + // 3: alarmTypeName
                "\"IS_OPEN\" INTEGER NOT NULL );"); // 4: isOpen
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"ALARM\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, Alarm entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        String alarmTime = entity.getAlarmTime();
        if (alarmTime != null) {
            stmt.bindString(2, alarmTime);
        }
        stmt.bindLong(3, entity.getAlarmType());
 
        String alarmTypeName = entity.getAlarmTypeName();
        if (alarmTypeName != null) {
            stmt.bindString(4, alarmTypeName);
        }
        stmt.bindLong(5, entity.getIsOpen() ? 1L: 0L);
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, Alarm entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        String alarmTime = entity.getAlarmTime();
        if (alarmTime != null) {
            stmt.bindString(2, alarmTime);
        }
        stmt.bindLong(3, entity.getAlarmType());
 
        String alarmTypeName = entity.getAlarmTypeName();
        if (alarmTypeName != null) {
            stmt.bindString(4, alarmTypeName);
        }
        stmt.bindLong(5, entity.getIsOpen() ? 1L: 0L);
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    @Override
    public Alarm readEntity(Cursor cursor, int offset) {
        Alarm entity = new Alarm( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // alarmTime
            cursor.getInt(offset + 2), // alarmType
            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3), // alarmTypeName
            cursor.getShort(offset + 4) != 0 // isOpen
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, Alarm entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setAlarmTime(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setAlarmType(cursor.getInt(offset + 2));
        entity.setAlarmTypeName(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setIsOpen(cursor.getShort(offset + 4) != 0);
     }
    
    @Override
    protected final Long updateKeyAfterInsert(Alarm entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(Alarm entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}