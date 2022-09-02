# 演習メモ

## 20.2

実行結果

Memory Used (shared version): 643144
Memory Used (unshared version): 649968

オーバヘッドがでかいため相対的に差が小さく見えるが6kB程度の差は出ている？

## 20.3

synchronizedにしないと、複数スレッドが同じ文字を同時にpoolに登録する余分な計算が発生する。