package site.lifd.core.io.resource;

import site.lifd.core.io.IORuntimeException;
import site.lifd.core.io.IoUtil;
import site.lifd.core.util.CharsetUtil;
import site.lifd.core.util.StrUtil;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.Serializable;
import java.io.StringReader;
import java.net.URL;
import java.nio.charset.Charset;

/**
 * {@link CharSequence}资源，字符串做为资源
 *
 */
public class CharSequenceResource implements Resource, Serializable {
	private static final long serialVersionUID = 1L;

	private final CharSequence data;
	private final CharSequence name;
	private final Charset charset;

	/**
	 * 构造，使用UTF8编码
	 *
	 * @param data 资源数据
	 */
	public CharSequenceResource(CharSequence data) {
		this(data, null);
	}

	/**
	 * 构造，使用UTF8编码
	 *
	 * @param data 资源数据
	 * @param name 资源名称
	 */
	public CharSequenceResource(CharSequence data, String name) {
		this(data, name, CharsetUtil.CHARSET_UTF_8);
	}

	/**
	 * 构造
	 *
	 * @param data 资源数据
	 * @param name 资源名称
	 * @param charset 编码
	 */
	public CharSequenceResource(CharSequence data, CharSequence name, Charset charset) {
		this.data = data;
		this.name = name;
		this.charset = charset;
	}

	@Override
	public String getName() {
		return StrUtil.str(this.name);
	}

	@Override
	public URL getUrl() {
		return null;
	}

	@Override
	public InputStream getStream() {
		return new ByteArrayInputStream(readBytes());
	}

	@Override
	public BufferedReader getReader(Charset charset) {
		return IoUtil.getReader(new StringReader(this.data.toString()));
	}

	@Override
	public String readStr(Charset charset) throws IORuntimeException {
		return this.data.toString();
	}

	@Override
	public byte[] readBytes() throws IORuntimeException {
		return this.data.toString().getBytes(this.charset);
	}

}
