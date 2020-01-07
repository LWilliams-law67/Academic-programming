package se.codequest.util;

import com.badlogic.gdx.tools.texturepacker.*;

public class TexturePackerTool
{
	public static void main(String[] args)
	{
		TexturePacker.process(
				"res/unpacked/", 
				"res/packed/",
				"textures");
	}

}
