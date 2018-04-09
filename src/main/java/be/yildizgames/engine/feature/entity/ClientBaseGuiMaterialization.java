/*
 *  This file is part of the Yildiz-Engine project, licenced under the MIT License  (MIT)
 *
 *  Copyright (c) 2018 Grégory Van den Borre
 *
 *  More infos available: https://www.yildiz-games.be
 *
 *  Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 *  The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 *  THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT  HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE  SOFTWARE.
 */

package be.yildizgames.engine.feature.entity;

import be.yildizgames.common.client.translation.TranslationKey;
import be.yildizgames.module.graphic.gui.button.ButtonMaterial;

/**
 * Common elements for the item GUI materialization.
 * Immutable class.
 *
 * @author Grégory Van den Borre
 */
//@specfield nameKey:Key:Translation key for the name.
//@specfield descriptionKey:Translation key for the description.
//@specfield icon:Material:2D representation of the element.
//@specfield constructionButton:ButtonMaterial:GuiButton to display to build the item.
//@invariant nameKey != null
//@invariant descriptionKey != null
//@invariant icon != null
//@invariant constructionButton != null
public class ClientBaseGuiMaterialization <T> {

    /**
     * ButtonMaterial to use on a button to build the matching element.
     */
    public final ButtonMaterial constructionButton;
    /**
     * Translation key for the GUI element name.
     */
    private final TranslationKey nameKey;
    /**
     * Translation key for the GUI element description.
     */
    private final TranslationKey descriptionKey;
    /**
     * Material to use to display the 2D GUI representation.
     */
    private final T icon;

    /**
     * Build the base GUI materialization.
     *
     * @param nameKey            Translation key for the GUI element name.
     * @param descriptionKey     Translation key for the GUI element description.
     * @param icon               Material to use to display the 2D GUI representation.
     * @param constructionButton ButtonMaterial to use on a button to build the matching element.
     */
    //@Requires nameKey != null
    //@Requires descriptionKey != null
    //@Requires icon != null
    //@Requires constructionMaterial != null
    protected ClientBaseGuiMaterialization(final TranslationKey nameKey, final TranslationKey descriptionKey, final T icon, final ButtonMaterial constructionButton) {
        super();
        this.nameKey = nameKey;
        this.descriptionKey = descriptionKey;
        this.icon = icon;
        this.constructionButton = constructionButton;
        assert this.invariant();
    }

    public ButtonMaterial getConstructionButton() {
        return constructionButton;
    }

    public TranslationKey getNameKey() {
        return nameKey;
    }

    public TranslationKey getDescriptionKey() {
        return descriptionKey;
    }

    public T getIcon() {
        return icon;
    }

    /**
     * Check the invariant.
     *
     * @return <code>true</code>
     * @throws IllegalArgumentException If the invariant is broken.
     */
    private boolean invariant() {
        if (this.nameKey == null) {
            throw new IllegalArgumentException("nameKey is null.");
        }
        if (this.descriptionKey == null) {
            throw new IllegalArgumentException("descriptionKey is null.");
        }
        if (this.icon == null) {
            throw new IllegalArgumentException("icon is null.");
        }
        if (this.constructionButton == null) {
            throw new IllegalArgumentException("constructionButton is null.");
        }
        return true;
    }
}
