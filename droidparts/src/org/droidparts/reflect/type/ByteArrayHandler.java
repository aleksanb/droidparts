/**
 * Copyright 2013 Alex Yanchenko
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *  
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License. 
 */
package org.droidparts.reflect.type;

import org.droidparts.reflect.util.TypeHelper;

import android.content.ContentValues;
import android.database.Cursor;

public class ByteArrayHandler extends TypeHandler<byte[]> {

	@Override
	public boolean canHandle(Class<?> cls) {
		return TypeHelper.isByteArray(cls);
	}

	@Override
	public String getDBColumnType() {
		return BLOB;
	}

	@Override
	protected byte[] parseFromString(Class<byte[]> cls, String str) {
		throw new IllegalArgumentException();
	}

	@Override
	public void putToContentValues(ContentValues cv, String key, Object val) {
		cv.put(key, (byte[]) val);
	}

	@Override
	public byte[] readFromCursor(Class<byte[]> cls, Cursor cursor,
			int columnIndex) {
		return cursor.getBlob(columnIndex);
	}

	@Override
	public Object parseTypeArr(Class<byte[]> arrValType, String[] arr) {
		throw new UnsupportedOperationException();
	}

}