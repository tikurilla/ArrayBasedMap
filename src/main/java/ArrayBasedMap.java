import java.util.*;

public class ArrayBasedMap<K, V> implements Map<K, V> {

    private List<Entry<K, V>> values = new ArrayList<>();

    @Override
    public int size() {
        // BEGIN (write your solution here)
        return values.size();
        // END
    }

    @Override
    public boolean isEmpty() {
        // BEGIN (write your solution here)
        return values.size() == 0;
        // END
    }

    @Override
    public boolean containsKey(Object key) {
        // BEGIN (write your solution here)
        if (key == null)
            throw new NullPointerException();
        for (Map.Entry<K, V> currentKey: values) {
            if (currentKey.getKey().equals((K)key)) {
                return true;
            }
        }
        return false;
        // END
    }

    @Override
    public boolean containsValue(Object value) {
        // BEGIN (write your solution here)
        if (value == null)
            throw new NullPointerException();
        for (Map.Entry<K, V> currentValue: values) {
            if (currentValue.getValue().equals((V)value)) {
                return true;
            }
        }
        return false;
        // END
    }

    @Override
    public V get(Object key) {
        // BEGIN (write your solution here)
        for (Map.Entry<K, V> currentPair: values) {
            if (currentPair.getKey().equals((K)key)) {
                return currentPair.getValue();
            }
        }
        return null;
        // END
    }

    @Override
    public V put(K key, V value) {
        // BEGIN (write your solution here)
        Map.Entry<K, V> newPair = new Pair(key, value);
        int currentIndex = 0;
        for (Map.Entry<K, V> currentPair: values) {
            if (currentPair.getKey().equals(newPair.getKey())) {
                V oldValue = currentPair.getValue();
                values.set(currentIndex, newPair);
                return oldValue;
            }
            currentIndex++;
        }
        values.add(newPair);
        return null;
        // END
    }

    @Override
    public V remove(Object key) {
        // BEGIN (write your solution here)
        return null;
        // END
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> m) {
        for (Map.Entry<K, V> e : (Set<Map.Entry<K, V>>)(Set)m.entrySet())
            put(e.getKey(), e.getValue());
    }

    @Override
    public void clear() {
        // BEGIN (write your solution here)

        // END
    }

    @Override
    public Set<K> keySet() {
        final Set<K> keys = new HashSet<K>();
        for (Entry<K, V> p : values) keys.add(p.getKey());
        return keys;
    }

    @Override
    public Collection<V> values() {
        // BEGIN (write your solution here)
        List<V> valuesList = new ArrayList<>();
        for (Map.Entry<K, V> currentPair: values) {
            valuesList.add(currentPair.getValue());
        }
        return (Collection<V>)valuesList;
        // END
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        return (Set<Entry<K, V>>)(Set)new HashSet<>(values);
    }

    private class Pair implements Map.Entry<K, V> {

        private final K key;

        private V value;

        private Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        @Override
        public V setValue(V value) {
            final V oldValue = this.value;
            this.value = value;
            return oldValue;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;

            Map.Entry<K, V> pair = (Map.Entry<K, V>) o;


            if (key != null ? !key.equals(pair.getKey()) : pair.getKey() != null) return false;
            return !(value != null ? !value.equals(pair.getValue()) : pair.getValue() != null);

        }

        @Override
        public int hashCode() {
            return (key   == null ? 0 :   key.hashCode()) ^
                    (value == null ? 0 : value.hashCode());
        }
    }
}
