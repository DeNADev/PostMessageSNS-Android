PostMessageSNS-Android
======================

Android 用の LINE / Twitter / Facebook / Mail への投稿用ライブラリです。

Android 2.3.3 から利用可能です。

ver. 1.3 より画像投稿機能を追加しました。ただし条件が厳しいので注意が必要です。

=================================================================================
バージョン
=================================================================================
1.3

=================================================================================
インポート方法
=================================================================================

Android 版 

- PostMessageSNS プロジェクトごと取り込んでください
 - workspace に Project をインポート
 - property -> Android -> Add でプロジェクトを指定すると使用可能になります。

=================================================================================
API 一覧 - Android 版
=================================================================================

// LINE に投稿するための API
public static boolean postMessage2LINE (String message, String url, Activity arg0)

	message
		(必須) 投稿する本文の内容
	url
		(必須) 投稿する URL
	arg0
		(必須) 親の Activity のインスタンス

※ ブラウザからアプリに戻ってくると、親の Activity の onActivityResult に requestCode = 1000 で通知が来ます。

// Twitter に投稿するための API
public static boolean postMessage2Twitter (String message, String url, Activity arg0)

	message
		(必須) 投稿する本文の内容
	url
		(必須) 投稿する URL
	arg0
		(必須) 親の Activity のインスタンス

※ ブラウザからアプリに戻ってくると、親の Activity の onActivityResult に requestCode = 1000 で通知が来ます。

// Facebook に投稿するための API
public static boolean postMessage2Facebook (String title, String message, String url, String appId, Activity arg0)

	title
		(必須) 投稿するタイトル
	message
		(必須) 投稿する本文の内容
	url
		(必須) 投稿する URL	
	appId
		(必須) Facebook の appId
	arg0
		(必須) 親の Activity のインスタンス

※ ブラウザからアプリに戻ってくると、親の Activity の onActivityResult に requestCode = 1000 で通知が来ます。

// Mail に投稿するための API
public static boolean postMessage2Mail (String title, String message, String url, Activity arg0)

	title
		(必須) 投稿するタイトル
	message
		(必須) 投稿する本文の内容
	url
		(必須) 投稿する URL	
	arg0
		(必須) 親の Activity のインスタンス

※ ブラウザからアプリに戻ってくると、親の Activity の onActivityResult に requestCode = 1000 で通知が来ます。

// Share Intent 起動用 API
public static boolean postMessage2ShareIntent(String title, String message, String url, Activity arg0)

	title
		(必須) 投稿するタイトル
	message
		(必須) 投稿する本文の内容
	url
		(必須) 投稿する URL	
	arg0
		(必須) 親の Activity のインスタンス

※ ShareIntent のダイアログを閉じる、もしくはアプリに戻ってくると、親の Activity の onActivityResult に requestCode = 1000 で通知が来ます。

// Twitter アプリに画像付き投稿するための API
public static boolean postMessage2TwitterWithImage (String message, String url, Uri imageUri, Activity arg0)

	message
		(必須) 投稿する本文の内容
	url
		(必須) 投稿する URL 
	imageUri
		(必須) 投稿する画像データまでのフルパス。ローカルファイルをフルパスで Uri 型で渡して下さい。
			例: android.resource://com.example.socialtest_android/drawable/ic_launcher
	arg0
		(必須) 親の Activity のインスタンス

※ この API は Twitter アプリに画像付き Intent を発行します。Twitter アプリが存在しない場合は、Twitter アプリのダウンロードページに遷移します。
※ Twitter アプリからアプリに戻ってくると、親の Activity の onActivityResult に requestCode = 1000 で通知が来ます。		

// Facebook に投稿する際に画像 URL 付きで投稿するための API
protected static boolean postMessage2FacebookWithImageURL (String title, String message, String url, String appId, String imageURL, Activity arg0)

	title
		(必須) 投稿するタイトル
	message
		(必須) 投稿する本文の内容
	url
		(必須) 投稿する URL
	appId
		(必須) Facebook の appId
	imageURL
		(必須) 投稿する画像の URL
	arg0
		(必須) 親の Activity のインスタンス

※ ブラウザに対して、画像 URL 付きで投稿します。
※ ブラウザからアプリに戻ってくると、親の Activity の onActivityResult に requestCode = 1000 で通知が来ます。		

// Gmail に画像付きで投稿するための API 
public static boolean postMessage2GmailWithImage (String title, String message, String url, Uri imageUri, Activity arg0)

	title
		(必須) 投稿するタイトル
	message
		(必須) 投稿する本文の内容
	url
		(必須) 投稿する URL
	appId
		(必須) Facebook の appId
	imageUri
		(必須) 投稿する画像データまでのフルパス。ローカルファイルをフルパスで Uri 型で渡して下さい。
			例: android.resource://com.example.socialtest_android/drawable/ic_launcher
	arg0
		(必須) 親の Activity のインスタンス
		
※ ブラウザからアプリに戻ってくると、親の Activity の onActivityResult に requestCode = 1000 で通知が来ます。
	
// 画像付き Share Intent 起動用 API [warning]アプリによっては不具合が出ます。Facebook は投稿内容が全て消えて起動します
public static boolean postMessage2ShareIntentWithImage(String title, String message, String url, Uri imageUri, Activity arg0)

	title
		(必須) 投稿するタイトル
	message
		(必須) 投稿する本文の内容
	url
		(必須) 投稿する URL
	imageUri
		(必須) 投稿する画像データまでのフルパス。ローカルファイルをフルパスで Uri 型で渡して下さい。
			例: android.resource://com.example.socialtest_android/drawable/ic_launcher
	arg0
		(必須) 親の Activity のインスタンス
		
※ ブラウザからアプリに戻ってくると、親の Activity の onActivityResult に requestCode = 1000 で通知が来ます。



