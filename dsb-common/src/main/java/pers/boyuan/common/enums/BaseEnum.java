package pers.boyuan.common.enums;

import java.util.Optional;
import java.util.function.Predicate;

/**
 * 基础枚举类接口
 *
 * @author ZhangBoyuan
 * @date 2022-06-25
 */
public interface BaseEnum<V> {

    V getValue();

    String getText();

    static <T extends Enum & BaseEnum> Optional<T> find(Class<T> type, Predicate<T> predicate) {
        if (type.isEnum()) {
            for (T baseEnum : type.getEnumConstants()) {
                if (predicate.test(baseEnum)) {
                    return Optional.of(baseEnum);
                }
            }
        }

        return Optional.empty();
    }

    static <T extends Enum & BaseEnum> Optional<T> findByValue(Class<T> type, Object value) {
        return find(type, e -> e.getValue() == value
                || e.getValue().equals(value)
                || String.valueOf(e.getValue()).equalsIgnoreCase(String.valueOf(value)));
    }

    static <T extends Enum & BaseEnum> Optional<T> findByText(Class<T> type, String text) {
        return find(type, e -> e.getText().equalsIgnoreCase(text));
    }

}
