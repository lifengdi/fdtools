package site.lifd.core.text.escape;

import site.lifd.core.text.replacer.LookupReplacer;

/**
 * HTML4的UNESCAPE
 *
 */
public class Html4Unescape extends XmlUnescape {
	private static final long serialVersionUID = 1L;

	protected static final String[][] ISO8859_1_UNESCAPE  = InternalEscapeUtil.invert(Html4Escape.ISO8859_1_ESCAPE);
	protected static final String[][] HTML40_EXTENDED_UNESCAPE  = InternalEscapeUtil.invert(Html4Escape.HTML40_EXTENDED_ESCAPE);

	public Html4Unescape() {
		super();
		addChain(new LookupReplacer(ISO8859_1_UNESCAPE));
		addChain(new LookupReplacer(HTML40_EXTENDED_UNESCAPE));
	}
}
