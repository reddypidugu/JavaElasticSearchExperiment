// Copyright (c) Philipp Wagner. All rights reserved.
// Licensed under the MIT license. See LICENSE file in the project root for full license information.

package csv.converter;

import de.bytefish.jtinycsvparser.typeconverter.ITypeConverter;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IgnoreMissingValuesConverter implements ITypeConverter<Float> {

    private List<String> missingValueRepresentation;

    public IgnoreMissingValuesConverter(String missingValueRepresentation) {
        this.missingValueRepresentation = Arrays.asList(missingValueRepresentation);
    }

    public IgnoreMissingValuesConverter(List<String> missingValueRepresentation) {
        this.missingValueRepresentation = missingValueRepresentation;
    }

    @Override
    public Float convert(final String s) {
        boolean isMissingValue = missingValueRepresentation
                .stream()
                .anyMatch(x -> x.equals(s));

        if(isMissingValue) {
            return null;
        }
        return Float.parseFloat(s);
    }

    @Override
    public Type getTargetType() {
        return Float.class;
    }
}
