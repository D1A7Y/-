package list;

/**
 * 　* @description: 顺序表
 * 　* @author dqy
 * 　* @date 2019/11/25
 */
public class SeqList<T> extends Object {
    /**
     * element:对象数组存储顺序表的数据元素
     */
    protected Object[] element;
    /**
     * n：顺序表元素个数
     */
    protected int n;

    public SeqList(int length) {
        this.element = new Object[length];
        this.n = 0;
    }

    public SeqList() {
        this(64);
    }

    public SeqList(T[] value) {
        this(value.length);
        for (int i = 0; i < value.length; i++) {
            this.element[i] = value[i];
        }
        this.n = element.length;
    }

    /**
     * //判断是否为空
     *
     * @return boolean, 空为true
     */
    public boolean isEmpty() {
        return this.n == 0;
    }

    /**
     * 返回元素个数
     *
     * @return 返回元素个数
     */
    public int size() {
        return this.n;
    }

    /**
     * 返回第i个元素
     *
     * @param i:第几个元素
     * @return (T)this.element[i]
     */
    public T get(int i) {
        if (i >= 0 && i < this.n) {
            return (T) this.element[i];
        }
        return null;
    }

    /**
     * 将顺序表的第i位元素设置为t，若t为空则抛出空对象异常，i越界则抛出序号越界异常
     *
     * @param i 第几个位置
     * @param t 传入的T元素
     */
    public void set(int i, T t) {
        if (t == null) {
            throw new NullPointerException();
        }
        if (i > 0 && i < this.n) {
            this.element[i] = t;
        } else {
            throw new IndexOutOfBoundsException(i + "");
        }

    }

    /**
     * 重写Object类的toString()方法，返回顺序表所有元素的描述字符串
     *
     * @return 返回顺序表所有元素的描述字符串
     */
    @Override
    public String toString() {
        String string = this.getClass().getName() + "(";
        if (this.n > 0) {
            string += this.element[0].toString();
        }
        for (int i = 1; i < this.n; i++) {
            string += "," + this.element[i].toString();
        }
        return string + ")";
    }

    /**
     * 返回顺序表所有元素的描述字符串(反向返回)
     *
     * @return String
     */
    public String toPreviousString() {
        String string = this.getClass().getName() + "(";
        if (this.n > 0) {
            string += this.element[this.n - 1].toString();
        }
        for (int i = this.n - 2; i > 0; i--) {
            string += "," + this.element[i].toString();
        }
        return string + ")";
    }

    /**
     * 在顺序表的i位置插入相应元素
     *
     * @param i 插入元素的位置
     * @param t 插入的元素
     * @return 返回插入的位置
     */
    public int insert(int i, T t) {
        if (t == null) {
            throw new NullPointerException("t==null");
        }
        if (i < 0) {
            i = 0;
        }
        if (i > this.n) {
            i = this.n;
        }
        Object[] source = this.element;
        if (this.n == element.length) {
            this.element = new Object[source.length * 2];
            for (int j = 0; j < i; j++) {
                this.element[i] = source[i];
            }
        }
        for (int j = this.n - 1; j > i; j--) {
            this.element[j + 1] = source[j];
        }
        this.element[i] = t;
        /*this.element[i] = t;
        for (int j = i; j < this.n - 1; j++) {
            this.element[i + 1] = source[i];
        }*/
        this.n++;
        return i;
    }

    /**
     * 按尾部插入元素
     *
     * @param t 插入的元素
     * @return 返回插入的位置
     */
    public int insert(T t) {
        return this.insert(this.n, t);
    }

    /**
     * 删除顺序表第i个元素
     *
     * @param i 要删除的元素位置
     * @return 返回被删除元素，若i越界则放回null
     */
    public T remove(int i) {
        if (this.n > 0 && i >= 0 && i < this.n) {
            T old = (T) this.element[i];
            for (int j = i; j < this.n - 1; j++) {
                this.element[j] = this.element[j + 1];
            }
            this.element[this.n - 1] = null;
            this.n--;
            return old;
        }
        return null;
    }


}
