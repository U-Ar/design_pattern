# 演習メモ

## 5.1

```java
public class TicketMaker {
    private static int ticket = 1000;

    public int get NextTicketNumber() {
        return ticket++;
    }
}
```

## 5.2

enumには自動生成されるvalueOfメソッドがあり、文字列から指定のインスタンスを得られる


## 5.3

インスタンス生成の前に2つのスレッドで同時にnull判定がされたとき、2つインスタンスが生成されるため。