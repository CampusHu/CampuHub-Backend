package com.example.campushub.user.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Type {
    STUDENT("학생"), PROFESSOR("PROFESSOR"), ADMIN("ADMIN");
    private final String key;

    public static Type fromKey(String key) {
        for (Type type : Type.values()) {
            if (type.key.equals(key)) {
                return type;
            }
        }

        return null;
    }

}
