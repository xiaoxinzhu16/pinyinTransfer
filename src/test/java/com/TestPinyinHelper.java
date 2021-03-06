package test.java.com;

import org.junit.Assert;
import org.junit.Test;

import main.java.com.PinyinException;
import main.java.com.PinyinFormat;
import main.java.com.PinyinHelper;

public class TestPinyinHelper {

	@Test
	public void testConvertToPinyinArray() {
		Assert.assertArrayEquals(PinyinHelper.convertToPinyinArray('为'), new String[] { "wèi", "wéi" });
		Assert.assertArrayEquals(PinyinHelper.convertToPinyinArray('为', PinyinFormat.WITH_TONE_MARK, ""),
				new String[] { "wèi", "wéi" });
		Assert.assertArrayEquals(PinyinHelper.convertToPinyinArray('为', PinyinFormat.WITH_TONE_NUMBER, ""),
				new String[] { "wei4", "wei2" });
		Assert.assertArrayEquals(PinyinHelper.convertToPinyinArray('为', PinyinFormat.WITHOUT_TONE, ""),
				new String[] { "wei" });

		Assert.assertArrayEquals(PinyinHelper.convertToPinyinArray('一'), new String[] { "yī" });
		Assert.assertArrayEquals(PinyinHelper.convertToPinyinArray('一', PinyinFormat.WITH_TONE_MARK, ""),
				new String[] { "yī" });
		Assert.assertArrayEquals(PinyinHelper.convertToPinyinArray('一', PinyinFormat.WITH_TONE_NUMBER, ""),
				new String[] { "yi1" });
		Assert.assertArrayEquals(PinyinHelper.convertToPinyinArray('一', PinyinFormat.WITHOUT_TONE, ""),
				new String[] { "yi" });
	}

	@Test
	public void testConvertToPinyinString() throws PinyinException {
		Assert.assertEquals(PinyinHelper.convertToPinyinString("你好世界", ","), "nǐ,hǎo,shì,jiè");
		Assert.assertEquals(PinyinHelper.convertToPinyinString("你好世界", ",", PinyinFormat.WITH_TONE_MARK, ""),
				"nǐ,hǎo,shì,jiè");
		Assert.assertEquals(PinyinHelper.convertToPinyinString("你好世界", ",", PinyinFormat.WITH_TONE_NUMBER, ""),
				"ni3,hao3,shi4,jie4");
		Assert.assertEquals(PinyinHelper.convertToPinyinString("你好世界", ",", PinyinFormat.WITHOUT_TONE, ""),
				"ni,hao,shi,jie");

		Assert.assertEquals(PinyinHelper.convertToPinyinString("绰绰有余", ","), "chuò,chuò,yǒu,yú");
		Assert.assertEquals(PinyinHelper.convertToPinyinString("绰绰有余", ",", PinyinFormat.WITH_TONE_MARK, ""),
				"chuò,chuò,yǒu,yú");
		Assert.assertEquals(PinyinHelper.convertToPinyinString("绰绰有余", ",", PinyinFormat.WITH_TONE_NUMBER, ""),
				"chuo4,chuo4,you3,yu2");
		Assert.assertEquals(PinyinHelper.convertToPinyinString("绰绰有余", ",", PinyinFormat.WITHOUT_TONE, ""),
				"chuo,chuo,you,yu");
	}

	@Test
	public void testHasMultiPinyin() {
		Assert.assertTrue(PinyinHelper.hasMultiPinyin('好'));
		Assert.assertTrue(!PinyinHelper.hasMultiPinyin('一'));

		Assert.assertTrue(!PinyinHelper.hasMultiPinyin('爱'));
		Assert.assertTrue(PinyinHelper.hasMultiPinyin('为'));
	}

	@Test
	public void testGetShortPinyin() throws PinyinException {
		Assert.assertEquals(PinyinHelper.getShortPinyin("你好世界", ""), "nhsj");

	}
	@Test
	public void testGetShortMulti() throws PinyinException {
		String[] r = PinyinHelper.getShortMulti("单小强", "");
	}
}
