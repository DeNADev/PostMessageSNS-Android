PostMessageSNS-Android
======================

提供 Android 上 LINE / Twitter / Facebook / Mail 投稿功能。

支持 Android 2.3.3 以上。

从 1.3 开始增加了图像投稿功能。可是有一定条件请注意。

=================================================================================
版本
=================================================================================
1.3

=================================================================================
把软件库加到项目里
=================================================================================

Android 版 

- 把 postmessagesns 项目加到 workspace 里
- 在应用的 property -> Android -> Add 里加上 postmessagesns 项目

=================================================================================
API 说明 - Android 版
=================================================================================

// LINE 投稿 API
public static boolean postMessage2LINE (String message, String url, Activity arg0)

	message
		(必须) 投稿内容
	url
		(必须) 投稿 URL
	arg0
		(必须) 显示投稿 UI 的主 Activity

* 从浏览器返回时，会给 arg0 的 onActivityResult 回调函数发 requestCode = 1000 通知。

// Twitter 投稿 API
public static boolean postMessage2Twitter (String message, String url, Activity arg0)

	message
		(必须) 投稿内容
	url
		(必须) 投稿 URL
	arg0
		(必须) 显示投稿 UI 的主 Activity

* 从浏览器返回时，会给 arg0 的 onActivityResult 回调函数发 requestCode = 1000 通知。

// Facebook 投稿 API
public static boolean postMessage2Facebook (String title, String message, String url, String appId, Activity arg0)

	title
		(必须) 投稿标题
	message
		(必须) 投稿内容
	url
		(必须) 投稿 URL
	appId
		(必须) Facebook 的 appId
	arg0
		(必须) 显示投稿 UI 的主 Activity

* 从浏览器返回时，会给 arg0 的 onActivityResult 回调函数发 requestCode = 1000 通知。

// Mail 投稿 API
public static boolean postMessage2Mail (String title, String message, String url, Activity arg0)

	title
		(必须) 投稿标题
	message
		(必须) 投稿内容
	url
		(必须) 投稿 URL
	arg0
		(必须) 显示投稿 UI 的主 Activity

* 从浏览器返回时，会给 arg0 的 onActivityResult 回调函数发 requestCode = 1000 通知。

// Share Intent 启动 API
public static boolean postMessage2ShareIntent(String title, String message, String url, Activity arg0)

	title
		(必须) 投稿标题
	message
		(必须) 投稿内容
	url
		(必须) 投稿 URL
	arg0
		(必须) 显示投稿 UI 的主 Activity

* 从 ShareIntent 的窗口返回时，会给 arg0 的 onActivityResult 回调函数发 requestCode = 1000 通知。

// 通过 Twitter 应用的图像投稿 API
public static boolean postMessage2TwitterWithImage (String message, String url, Uri imageUri, Activity arg0)

	message
		(必须) 投稿内容
	url
		(必须) 投稿 URL
	imageUri
		(必须) 投稿图像的档案途径。把本地的完整途径以 Uri 方式指定。
		如：android.resource://com.example.socialtest_android/drawable/ic_launcher
	arg0
		(必须) 显示投稿 UI 的主 Activity

* 这 API 会发起调用 Twitter 应用的 Intent。如果还没安装 Twitter 应用，会跳到 Twitter 应用的下载网站。
* 从 Twitter 应用返回时，会给 arg0 的 onActivityResult 回调函数发 requestCode = 1000 通知。

// Facebook 图像 URL 投稿 API (使用浏览器)
protected static boolean postMessage2FacebookWithImageURL (String title, String message, String url, String appId, String imageURL, Activity arg0)

	title
		(必须) 投稿标题
	message
		(必须) 投稿内容
	url
		(必须) 投稿 URL
	appId
		(必须) Facebook 的 appId
	imageURL
		(必须) 投稿图像的 URL
	arg0
		(必须) 显示投稿 UI 的主 Activity

* 使用浏览器投稿图像 URL。
* 从浏览器返回时，会给 arg0 的 onActivityResult 回调函数发 requestCode = 1000 通知。

// Gmail 图像投稿 API 
public static boolean postMessage2GmailWithImage (String title, String message, String url, Uri imageUri, Activity arg0)

	title
		(必须) 投稿标题
	message
		(必须) 投稿内容
	url
		(必须) 投稿 URL
	appId
		(必须) Facebook 的 appId
	imageUri
		(必须) 投稿图像的档案途径。把本地的完整途径以 Uri 方式指定。
		如：android.resource://com.example.socialtest_android/drawable/ic_launcher
	arg0
		(必须) 显示投稿 UI 的主 Activity
		
* 从浏览器返回时，会给 arg0 的 onActivityResult 回调函数发 requestCode = 1000 通知。
	
// 图像投稿 Share Intent 启动 API
// [warning] 根据投稿对象会有不一样的结果，像 Facebook 会删除投稿内容。
public static boolean postMessage2ShareIntentWithImage(String title, String message, String url, Uri imageUri, Activity arg0)

	title
		(必须) 投稿标题
	message
		(必须) 投稿内容
	url
		(必须) 投稿 URL
	imageUri
		(必须) 投稿图像的档案途径。把本地的完整途径以 Uri 方式指定。
		如：android.resource://com.example.socialtest_android/drawable/ic_launcher
	arg0
		(必须) 显示投稿 UI 的主 Activity
		
* 从浏览器返回时，会给 arg0 的 onActivityResult 回调函数发 requestCode = 1000 通知。



