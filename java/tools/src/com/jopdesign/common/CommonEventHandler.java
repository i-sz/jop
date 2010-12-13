/*
 * This file is part of JOP, the Java Optimized Processor
 *   see <http://www.jopdesign.com/>
 *
 * Copyright (C) 2010, Stefan Hepp (stefan@stefant.org).
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.jopdesign.common;

/**
 * The common keys class registers and manages keys common to all tools.
 *
 * @author Stefan Hepp (stefan@stefant.org)
 */
public class CommonEventHandler extends EmptyAppEventHandler {

    public static KeyManager.CustomKey KEY_LOOPBOUND;

    @Override
    public void onRegisterEventHandler(AppInfo appInfo) {
        KEY_LOOPBOUND = KeyManager.getSingleton().registerStructKey("loopbound");

    }

    @Override
    public void onCreateClass(ClassInfo classInfo, boolean loaded) {
        if (!loaded) {
            return;
        }
        // TODO load annotations from sourcecode comments to CustomValues (?)

    }
}
