/*******************************************************************************
 * This file is part of Pebble.
 * 
 * Copyright (c) 2014 by Mitchell Bösecke
 * 
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 ******************************************************************************/
package com.mitchellbosecke.pebble.extension.i18n;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;

import com.mitchellbosecke.pebble.extension.LocaleAware;
import com.mitchellbosecke.pebble.extension.Function;

public class i18nFunction implements Function, LocaleAware {

	private Locale locale;

	public void setLocale(Locale locale) {
		this.locale = locale;
	}

	@Override
	public List<String> getArgumentNames() {
		List<String> names = new ArrayList<>();
		names.add("bundle");
		names.add("key");
		return names;
	}

	@Override
	public Object execute(Map<String, Object> args) {
		String basename = (String) args.get("bundle");
		String key = (String) args.get("key");

		ResourceBundle bundle = ResourceBundle.getBundle(basename, locale);

		return bundle.getObject(key);
	}

}