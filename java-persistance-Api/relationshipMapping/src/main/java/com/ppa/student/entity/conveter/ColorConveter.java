package com.ppa.student.entity.conveter;

import java.awt.Color;
import java.math.BigDecimal;
import java.math.RoundingMode;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter
public class ColorConveter implements AttributeConverter<Color, String> {

	@Override
	public String convertToDatabaseColumn(Color color) {

		if(null != color) {
			return "%s,%s,%s".formatted(color.getRed(),color.getGreen(),color.getBlue());
		}
		return null;
	}

	@Override
	public Color convertToEntityAttribute(String str) {
		
		if(null != str && !str.isBlank()) {
			var color = str.split(",");
			return new Color(colorCode(color[0]), colorCode(color[1]), colorCode(color[2]));
		}
		return null;
	}

	private float colorCode(String string) {
		var value =  new BigDecimal(string);
		return  value.divide(new BigDecimal(255), 16, RoundingMode.HALF_UP).floatValue();
	}

}
