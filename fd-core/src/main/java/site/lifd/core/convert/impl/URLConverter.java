package site.lifd.core.convert.impl;

import java.io.File;
import java.net.URI;
import java.net.URL;

import site.lifd.core.convert.AbstractConverter;

/**
 * URL对象转换器
 * *
 */
public class URLConverter extends AbstractConverter<URL>{
	private static final long serialVersionUID = 1L;

	@Override
	protected URL convertInternal(Object value) {
		try {
			if(value instanceof File){
				return ((File)value).toURI().toURL();
			}

			if(value instanceof URI){
				return ((URI)value).toURL();
			}
			return new URL(convertToStr(value));
		} catch (Exception e) {
			// Ignore Exception
		}
		return null;
	}

}
