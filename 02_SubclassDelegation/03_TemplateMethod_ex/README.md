# 演習問題メモ
## 3.1

InputStreamを継承するクラスはreadメソッドを実装することが要求されている

入力ストリームからデータの次のバイトを読み込むもの

## 3.2

メソッドを修飾するfinalの意味は、オーバーライドを禁止すること。
テンプレートメソッドの場合オーバーライドを禁止する必要があるので明示的にfinalを付けるとよい。

クラスであれば継承を禁止するし、フィールドであれば値の再代入を禁止する。

## 3.3

protected修飾子を付ければパッケージ内と継承関係にあるクラスからのみ使える。

- 修飾子なしでパッケージ内とクラス内のみ
- privateでクラス内のみ
- publicで全範囲

パッケージ内外とクラス内外、継承関係という3種のスコープがあるのに注意。

## 3.4

AbstractDisplayをインタフェースにしてdisplayをdefault実装で提供する変更。

結局のところユーザからするとインタフェースとは抽象メソッドしか持たない抽象クラスそのもの。

抽象メソッドのみだからこそ多重継承で起こりうるような衝突は複数のインタフェース実装では怒らないのだろう。





