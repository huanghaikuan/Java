## Annotation注解

### 准确的覆写：@Override
明确表示该方法是一个覆写来方法，系统会自动语法检测
```
class A {
    public void connect() {}
}
class B extend A {
    @Override
    public void connect() {}
}
```

### 过期操作：@Deprecated


### 压制警告：@SuppressWarning