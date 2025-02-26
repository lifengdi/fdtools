package site.lifd.core.text.csv;

import site.lifd.core.util.CharUtil;

import java.io.Serializable;

/**
 * CSV写出配置项
 *
 * */
public class CsvWriteConfig extends CsvConfig<CsvWriteConfig> implements Serializable {
	private static final long serialVersionUID = 5396453565371560052L;

	/**
	 * 是否始终使用文本分隔符，文本包装符，默认false，按需添加
	 */
	protected boolean alwaysDelimitText;
	/**
	 * 换行符
	 */
	protected char[] lineDelimiter = {CharUtil.CR, CharUtil.LF};

	/**
	 * 文件末尾是否添加换行符<br>
	 * 按照https://datatracker.ietf.org/doc/html/rfc4180#section-2 规范，末尾换行符可有可无。
	 */
	protected boolean endingLineBreak;

	/**
	 * 默认配置
	 *
	 * @return 默认配置
	 */
	public static CsvWriteConfig defaultConfig() {
		return new CsvWriteConfig();
	}

	/**
	 * 设置是否始终使用文本分隔符，文本包装符，默认false，按需添加
	 *
	 * @param alwaysDelimitText 是否始终使用文本分隔符，文本包装符，默认false，按需添加
	 * @return this
	 */
	public CsvWriteConfig setAlwaysDelimitText(boolean alwaysDelimitText) {
		this.alwaysDelimitText = alwaysDelimitText;
		return this;
	}

	/**
	 * 设置换行符
	 *
	 * @param lineDelimiter 换行符
	 * @return this
	 */
	public CsvWriteConfig setLineDelimiter(char[] lineDelimiter) {
		this.lineDelimiter = lineDelimiter;
		return this;
	}

	/**
	 * 文件末尾是否添加换行符<br>
	 * 按照https://datatracker.ietf.org/doc/html/rfc4180#section-2 规范，末尾换行符可有可无。
	 *
	 * @param endingLineBreak 文件末尾是否添加换行符
	 * @return this
	 */
	public CsvWriteConfig setEndingLineBreak(boolean endingLineBreak) {
		this.endingLineBreak = endingLineBreak;
		return this;
	}
}
