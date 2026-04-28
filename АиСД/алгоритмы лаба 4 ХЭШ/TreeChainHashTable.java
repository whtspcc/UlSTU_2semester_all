public class TreeChainHashTable<K extends Comparable<K>, V> {
    private static class TreeNode<K, V> {
        K key;
        V value;
        TreeNode<K, V> left, right;
        // ссылки на детей - left -> меньше родителя, right -> больше родителя
        // родитель - ключ !!

        TreeNode(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private TreeNode<K, V>[] buckets;

    @SuppressWarnings("unchecked")
    public TreeChainHashTable(int capacity) {
        buckets = new TreeNode[capacity];
    }

    private int getIndex(K key) {
        return Math.abs(key.hashCode()) % buckets.length;
    }

    public void put(K key, V value) {
        int index = getIndex(key);
        buckets[index] = insert(buckets[index], key, value);
    }

    private TreeNode<K, V> insert(TreeNode<K, V> node, K key, V value) {
        if (node == null) return new TreeNode<>(key, value);

        // сравниваем ключи, если такой ключ уже есть
        int cmp = key.compareTo(node.key);
        // если ключ меньше - идем в левую ветку и перезаписываем результатом вставки
        if (cmp < 0) {
            node.left = insert(node.left, key, value);
        // если больше - в правую и так же перезапимываем
        } else if (cmp > 0) {
            node.right = insert(node.right, key, value);
        // ключ найден — обновляем значение
        } else {
            node.value = value;
        }
        return node;
    }

    public V get(K key) {
        int index = getIndex(key);
        return find(buckets[index], key);
    }

    private V find(TreeNode<K, V> node, K key) {
        if (node == null) return null;
        int cmp = key.compareTo(node.key); // compareto выводит либо -NUM либо +NUM
        if (cmp < 0) return find(node.left, key);
        if (cmp > 0) return find(node.right, key);
        return node.value;
    }
}