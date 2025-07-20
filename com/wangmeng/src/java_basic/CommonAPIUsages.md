## Java 常用算法 API 与模板速查表

---

### 🧱 基础数据结构

#### ✅ 数组

```java
import java.util.Collections;

int[] arr = new int[10];
int[] arr2 = {1, 2, 3};
Arrays.sort(arr);

// if want to sort it in reverse order
Integer[] boxed = Arrays.stream(nums).boxed().toArray(Integer[]::new);
Arrays.sort(boxed, Collections.reverseOrder());
binarySearch(arr, x);
```

#### ✅ 字符串
```java
String s = "hello";
char c = s.charAt(0);
String sub = s.substring(1, 3);
String[] parts = s.split(" ");
s.equals("abc");
s.toCharArray();
```

---

### 🗃 集合类

#### ✅ List
```java
List<Integer> list = new ArrayList<>();
list.add(1);
list.get(0);
list.remove(1);
Collections.sort(list);
Collections.sort(list, Collections.reverseOrder());
```

#### ✅ LinkedList（双端队列）
```java
LinkedList<Integer> deque = new LinkedList<>();
deque.addFirst(1);
deque.addLast(2);
deque.pollFirst();
deque.pollLast();
```

---

### 📚 栈与队列

#### ✅ Stack
```java
Stack<Integer> stack = new Stack<>();
stack.push(1);
stack.pop();
stack.peek();
```

#### ✅ Queue
```java
Queue<Integer> queue = new LinkedList<>();
queue.offer(1); // 入队
queue.poll(); // 出队并返回队首元素
queue.peek();
```

#### ✅ Deque
```java
Deque<Integer> deque = new ArrayDeque<>();
deque.push(1);
deque.pop();
deque.offerFirst(1);
deque.offerLast(2);
```

---

### 🔥 堆（优先队列）

It's used to access maximum/minimum value
#### ✅ 最小堆
```java
PriorityQueue<Integer> minHeap = new PriorityQueue<>();
minHeap.offer(3);
minHeap.offer(1);
minHeap.poll();
```

#### ✅ 最大堆
```java
PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
```

---

### 🔎 映射与集合

#### ✅ HashMap
```java
Map<String, Integer> map = new HashMap<>();
map.put("a", 1);
map.get("a");
map.containsKey("a");
map.remove("a");
for (Map.Entry<String, Integer> entry : map.entrySet()) {
    System.out.println(entry.getKey() + ":" + entry.getValue());
}
```

#### ✅ HashSet
```java
Set<Integer> set = new HashSet<>();
set.add(1);
set.contains(2);
set.remove(1);
```

---

### 📏 排序与搜索

#### ✅ 数组排序
```java
Arrays.sort(arr);
Arrays.sort(arr, Collections.reverseOrder()); // Integer[]
```

#### ✅ 自定义排序
```java
Arrays.sort(arr, (a, b) -> b - a);
list.sort((a, b) -> a.value - b.value);
```

---

### ⏱ 实用工具类

#### ✅ Arrays & Collections
```java
Arrays.equals(arr1, arr2);
Arrays.fill(arr, 1);
Collections.sort(list);
Collections.reverse(list);
Collections.max(list);
Collections.min(list);
```

---

### 💡 其他常用写法

#### ✅ for-each 遍历
```java
for (int num : arr) { ... }
for (int num : list) { ... }
```

#### ✅ Stream
```java
list.stream().filter(x -> x > 0).collect(Collectors.toList());
```

---

## 🚀 BFS 模板
```java
Queue<int[]> queue = new LinkedList<>();
boolean[][] visited = new boolean[m][n];
queue.offer(new int[]{startX, startY});
visited[startX][startY] = true;
while (!queue.isEmpty()) {
    int[] cur = queue.poll();
    for (int[] dir : dirs) {
        int nx = cur[0] + dir[0], ny = cur[1] + dir[1];
        if (合法坐标 && !visited[nx][ny]) {
            visited[nx][ny] = true;
            queue.offer(new int[]{nx, ny});
        }
    }
}
```

## 🧭 DFS 模板
```java
void dfs(int x, int y) {
    if (越界 || visited[x][y]) return;
    visited[x][y] = true;
    for (int[] dir : dirs) {
        dfs(x + dir[0], y + dir[1]);
    }
}
```

## 🔍 二分查找模板
```java
int left = 0, right = nums.length - 1;
while (left <= right) {
    int mid = left + (right - left) / 2;
    if (nums[mid] == target) return mid;
    else if (nums[mid] < target) left = mid + 1;
    else right = mid - 1;
}
```

## 🧩 回溯模板
```java
void backtrack(List<Integer> path, boolean[] used, int[] nums) {
    if (path.size() == nums.length) {
        res.add(new ArrayList<>(path));
        return;
    }
    for (int i = 0; i < nums.length; i++) {
        if (used[i]) continue;
        used[i] = true;
        path.add(nums[i]);
        backtrack(path, used, nums);
        path.remove(path.size() - 1);
        used[i] = false;
    }
}
```

## 🧷 并查集模板
```java
class UnionFind {
    int[] parent;
    UnionFind(int n) {
        parent = new int[n];
        for (int i = 0; i < n; i++) parent[i] = i;
    }
    int find(int x) {
        if (parent[x] != x) parent[x] = find(parent[x]);
        return parent[x];
    }
    void union(int x, int y) {
        parent[find(x)] = find(y);
    }
    boolean connected(int x, int y) {
        return find(x) == find(y);
    }
}
```

## 📚 Trie 树模板
```java
class TrieNode {
    TrieNode[] children = new TrieNode[26];
    boolean isWord = false;
}

class Trie {
    TrieNode root = new TrieNode();
    void insert(String word) {
        TrieNode cur = root;
        for (char c : word.toCharArray()) {
            if (cur.children[c - 'a'] == null)
                cur.children[c - 'a'] = new TrieNode();
            cur = cur.children[c - 'a'];
        }
        cur.isWord = true;
    }
    boolean search(String word) {
        TrieNode cur = root;
        for (char c : word.toCharArray()) {
            if (cur.children[c - 'a'] == null) return false;
            cur = cur.children[c - 'a'];
        }
        return cur.isWord;
    }
    boolean startsWith(String prefix) {
        TrieNode cur = root;
        for (char c : prefix.toCharArray()) {
            if (cur.children[c - 'a'] == null) return false;
            cur = cur.children[c - 'a'];
        }
        return true;
    }
}
```

## 🧠 滑动窗口模板
```java
int left = 0, sum = 0, res = Integer.MAX_VALUE;
for (int right = 0; right < nums.length; right++) {
    sum += nums[right];
    while (sum >= target) {
        res = Math.min(res, right - left + 1);
        sum -= nums[left++];
    }
}
```
