package com.java.collection;

import java.util.HashMap;
import java.util.IdentityHashMap;

public class IdentityHashMapTest {
    public static void main(String[] args) {
        IdentityHashMap<Key, Object> identityHashMap = new IdentityHashMap<>();
        identityHashMap.put(new Key(), new Object());
        identityHashMap.put(new Key(), new Object());
        System.out.println(identityHashMap.size());

        HashMap<Key, Object> hashMap = new HashMap<>();
        hashMap.put(new Key(), new Object());
        hashMap.put(new Key(), new Object());
        System.out.println(hashMap.size());

    }

    static class Key {
        @Override
        public int hashCode() {
            return 1;
        }

        @Override
        public boolean equals(Object obj) {
            return obj instanceof Key && hashCode() == obj.hashCode();
        }
    }
}
