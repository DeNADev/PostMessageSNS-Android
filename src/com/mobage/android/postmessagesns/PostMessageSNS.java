/**
 * The MIT License (MIT)
 * Copyright (c) 2014 DeNA Co., Ltd.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 **/

package com.mobage.android.postmessagesns;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;

public class PostMessageSNS {

    public static boolean postMessage2LINE (String message, String url, Activity arg0)
    {
        return message2LINE ( message, url, arg0);
    }
    public static boolean postMessage2Twitter (String message, String url, Activity arg0)
    {
        return message2Twitter ( message, url, arg0);
    }
    public static boolean postMessage2Facebook (String title, String message, String url, String appId, Activity arg0)
    {
        return message2Facebook ( title, message, url, appId, arg0);
    }
    public static boolean postMessage2Mail (String title, String message, String url, Activity arg0)
    {
        return message2Mail ( title, message, url, arg0);
    }
    public static boolean postMessage2ShareIntent(String title, String message, String url, Activity arg0)
    {
        return message2ShareIntent(title, message, url, arg0);
    }

    public static boolean postMessage2TwitterWithImage (String message, String url, Uri imageUri, Activity arg0)
    {
        return message2TwitterWithImage ( message, url, imageUri, arg0);
    }
    protected static boolean postMessage2FacebookWithImageURL (String title, String message, String url, String appId, String imageURL, Activity arg0)
    {
        return message2FacebookWithImageURL ( title, message, url, imageURL, appId, arg0);
    }
    public static boolean postMessage2GmailWithImage (String title, String message, String url, Uri imageUri, Activity arg0)
    {
        return message2GmailWithImage ( title, message, url, imageUri, arg0);
    }
    public static boolean postMessage2ShareIntentWithImage(String title, String message, String url, Uri imageUri, Activity arg0)
    {
        return message2ShareIntentWithImage(title, message, url, imageUri, arg0);
    }
    
    
    protected static boolean message2LINE (String message, String url, Activity arg0)
    {
        if ( message == null || message.length() == 0 )
        {
            return false;
        }
        if ( url == null || url.length() == 0 )
        {
            return false;
        }
        String temp = message + " " + url;
        String encodeTemp = "";
        try 
        {
            encodeTemp = URLEncoder.encode(temp, "utf-8");
        } 
        catch (UnsupportedEncodingException e) 
        {
            // TODO 自動生成された catch ブロック
            e.printStackTrace();
            return false;
        }
        
        // インテントのインスタンス生成
        Intent intent = new Intent();
        // インテントにアクション及びURLをセット
        intent.setAction(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("http://line.naver.jp/R/msg/text/?" + encodeTemp));
        // ブラウザ起動
        arg0.startActivityForResult(intent, 1000);
        return true;
    }
    
    protected static boolean message2Twitter (String message, String url, Activity arg0)
    {
        if ( message == null || message.length() == 0 )
        {
            return false;
        }
        if ( url == null || url.length() == 0 )
        {
            return false;
        }

        String encodeMessage = "";
        try 
        {
            encodeMessage = URLEncoder.encode(message, "utf-8");
        } 
        catch (UnsupportedEncodingException e) 
        {
            // TODO 自動生成された catch ブロック
            e.printStackTrace();
            return false;
        }
        
        String encodeUrl = "";
        try 
        {
            encodeUrl = URLEncoder.encode(url, "utf-8");
        } 
        catch (UnsupportedEncodingException e) 
        {
            // TODO 自動生成された catch ブロック
            e.printStackTrace();
            return false;
        }
        
        Intent shareIntent = new Intent(Intent.ACTION_SEND);
        shareIntent.setType("text/plain");
        
        shareIntent.putExtra(Intent.EXTRA_TEXT, message + " " + url);
        shareIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
        shareIntent.addFlags(Intent.FLAG_GRANT_WRITE_URI_PERMISSION);
        String appName = "twitter"; 
        
        PackageManager pm = arg0.getPackageManager();
        List<ResolveInfo> activityList = pm.queryIntentActivities(shareIntent, 0);
        boolean isExistTwitter = false;
        for(ResolveInfo app : activityList)
        {
            if ((app.activityInfo.name.contains(appName))) 
            {
                ActivityInfo activity = app.activityInfo;
                shareIntent.setClassName(activity.applicationInfo.packageName, activity.name);
                arg0.startActivityForResult(shareIntent, 1000);
                isExistTwitter = true;
                break;
            }
        }
        if(isExistTwitter == false)
        {
            // インテントのインスタンス生成
            Intent intent = new Intent();
            // インテントにアクション及びURLをセット
            intent.setAction(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("https://twitter.com/share?text=" + encodeMessage + "&url=" + encodeUrl));
            // ブラウザ起動
            arg0.startActivityForResult(intent, 1000);
        }
        
        return true;
    }
    
    protected static boolean message2TwitterWithImage (String message, String url, Uri imageUri, final Activity arg0)
    {
        if ( message == null || message.length() == 0 )
        {
            return false;
        }
        if ( url == null || url.length() == 0 )
        {
            return false;
        }

        Intent shareIntent = new Intent(Intent.ACTION_SEND);
        shareIntent.setType("image/png");
        
        shareIntent.putExtra(Intent.EXTRA_STREAM, imageUri);
        shareIntent.putExtra(Intent.EXTRA_TEXT, message + " " + url);
        shareIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
        shareIntent.addFlags(Intent.FLAG_GRANT_WRITE_URI_PERMISSION);
        String appName = "twitter"; 

        PackageManager pm = arg0.getPackageManager();
        List<ResolveInfo> activityList = pm.queryIntentActivities(shareIntent, 0);
        boolean isExistTwitter = false;
        for(ResolveInfo app : activityList)
        {
            if ((app.activityInfo.name.contains(appName))) 
            {
                ActivityInfo activity = app.activityInfo;
                shareIntent.setClassName(activity.applicationInfo.packageName, activity.name);
                arg0.startActivityForResult(shareIntent, 1000);
                isExistTwitter = true;
                break;
            }
        }
        if(isExistTwitter == false)
        {
            AlertDialog.Builder alert = new AlertDialog.Builder(arg0);  
            alert.setTitle("Twitter アプリ未検出");  
            alert.setMessage("Twitter アプリが見つかりませんでした。ダウンロードしますか？（ダウンロード後にもう一度シェアして下さい）");  
            alert.setPositiveButton("Yes", new DialogInterface.OnClickListener(){  
                public void onClick(DialogInterface dialog, int which) { 
                    Uri uri = Uri.parse("https://play.google.com/store/apps/details?id=com.twitter.android&hl=ja");
                        Intent i = new Intent(Intent.ACTION_VIEW,uri);
                        arg0.startActivity(i);
                }});  
            alert.setNegativeButton("No", new DialogInterface.OnClickListener(){  
                public void onClick(DialogInterface dialog, int which) {  
                }});  
            alert.show();  

        }
        
        return true;
    }
    
    protected static boolean message2Facebook (String title, String message, String url, String appId, Activity arg0)
    {
        if ( title == null || title.length() == 0 )
        {
            return false;
        }
        if ( message == null || message.length() == 0 )
        {
            return false;
        }
        if ( url == null || url.length() == 0 )
        {
            return false;
        }
        if ( appId == null || appId.length() == 0 )
        {
            return false;
        }
    
        String encodeTitle = "";
        try 
        {
            encodeTitle = URLEncoder.encode(title, "utf-8");
        } 
        catch (UnsupportedEncodingException e) 
        {
            // TODO 自動生成された catch ブロック
            e.printStackTrace();
            return false;
        }
        
        String encodeMessage = "";
        try 
        {
            encodeMessage = URLEncoder.encode(message, "utf-8");
        }
        catch (UnsupportedEncodingException e) 
        {
            // TODO 自動生成された catch ブロック
            e.printStackTrace();
            return false;
        }
        
        String encodeUrl = "";
        try
        {
            encodeUrl = URLEncoder.encode(url, "utf-8");
        }
        catch (UnsupportedEncodingException e) 
        {
            // TODO 自動生成された catch ブロック
            e.printStackTrace();
            return false;
        }
    
        // インテントのインスタンス生成
        Intent intent = new Intent();
        // インテントにアクション及びURLをセット
        intent.setAction(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("https://www.facebook.com/dialog/feed?app_id=" + appId + "&display=popup&caption=" + encodeTitle + "&link=" + encodeUrl + "&redirect_uri=https://www.facebook.com&description=" + encodeMessage));
        // ブラウザ起動
        arg0.startActivityForResult(intent, 1000);
        
        return true;
    }
    
    protected static boolean message2FacebookWithImageURL (String title, String message, String url, String appId, String imageURL, Activity arg0)
    {
        if ( title == null || title.length() == 0 )
        {
            return false;
        }
        if ( message == null || message.length() == 0 )
        {
            return false;
        }
        if ( url == null || url.length() == 0 )
        {
            return false;
        }
        if ( appId == null || appId.length() == 0 )
        {
            return false;
        }
        if ( imageURL == null || imageURL.length() == 0)
        {
            return false;
        }
    
        String encodeTitle = "";
        try 
        {
            encodeTitle = URLEncoder.encode(title, "utf-8");
        } 
        catch (UnsupportedEncodingException e) 
        {
            // TODO 自動生成された catch ブロック
            e.printStackTrace();
            return false;
        }
        
        String encodeMessage = "";
        try 
        {
            encodeMessage = URLEncoder.encode(message, "utf-8");
        } 
        catch (UnsupportedEncodingException e) 
        {
            // TODO 自動生成された catch ブロック
            e.printStackTrace();
            return false;
        }
        
        String encodeUrl = "";
        try 
        {
            encodeUrl = URLEncoder.encode(url, "utf-8");
        }
        catch (UnsupportedEncodingException e) 
        {
            // TODO 自動生成された catch ブロック
            e.printStackTrace();
            return false;
        }
        
        String encodeImageUrl = "";
        try 
        {
            encodeImageUrl = URLEncoder.encode(imageURL, "utf-8");
        }
        catch (UnsupportedEncodingException e) 
        {
            // TODO 自動生成された catch ブロック
            e.printStackTrace();
            return false;
        }
        
        // インテントのインスタンス生成
        Intent intent = new Intent();
        // インテントにアクション及びURLをセット
        intent.setAction(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("https://www.facebook.com/dialog/feed?app_id=" + appId + "&display=popup&caption=" + encodeTitle + "&link=" + encodeUrl + "&picture" + encodeImageUrl + "&redirect_uri=https://www.facebook.com&description=" + encodeMessage));
        // ブラウザ起動
        arg0.startActivityForResult(intent, 1000);
        
        return true;
    }
    
    protected static boolean message2Mail (String title, String message, String url, Activity arg0)
    {
        if ( title == null || title.length() == 0 )
        {
            return false;
        }
        if ( message == null || message.length() == 0 )
        {
            return false;
        }
        if ( url == null || url.length() == 0 )
        {
            return false;
        }

        // インテントのインスタンス生成
        Intent intent = new Intent();
        // インテントにアクション及びURLをセット
        intent.setAction(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("mailto:"));
        intent.putExtra(Intent.EXTRA_SUBJECT, title);
        intent.putExtra(Intent.EXTRA_TEXT, message + " " + url);
        // ブラウザ起動
        arg0.startActivityForResult(intent, 1000);
        
        return true;
    }
    
    protected static boolean message2GmailWithImage (String title, String message, String url, Uri imageUri, final Activity arg0)
    {
        if ( title == null || title.length() == 0 )
        {
            return false;
        }
        if ( message == null || message.length() == 0 )
        {
            return false;
        }
        if ( url == null || url.length() == 0 )
        {
            return false;
        }
        
        Intent shareIntent = new Intent(Intent.ACTION_SEND);
        shareIntent.setType("image/png");
        
        shareIntent.putExtra(Intent.EXTRA_STREAM, imageUri);
        shareIntent.putExtra(Intent.EXTRA_TEXT, message + " " + url);
        shareIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
        shareIntent.addFlags(Intent.FLAG_GRANT_WRITE_URI_PERMISSION);
        String appName = "Gmail"; 

        PackageManager pm = arg0.getPackageManager();
        List<ResolveInfo> activityList = pm.queryIntentActivities(shareIntent, 0);
        boolean isExistGmail = false;
        for(ResolveInfo app : activityList)
        {
            if ((app.activityInfo.name.contains(appName))) 
            {
                ActivityInfo activity = app.activityInfo;
                shareIntent.setClassName(activity.applicationInfo.packageName, activity.name);
                arg0.startActivityForResult(shareIntent, 1000);
                isExistGmail = true;
                break;
            }
        }
        if(isExistGmail == false)
        {
            AlertDialog.Builder alert = new AlertDialog.Builder(arg0);  
            alert.setTitle("Gmail アプリ未検出");  
            alert.setMessage("Gmail アプリが見つかりませんでした。");  
            alert.setPositiveButton("Yes", new DialogInterface.OnClickListener(){  
                public void onClick(DialogInterface dialog, int which) { 
                }});  
            alert.show();
        }
        
        return true;
    }
    
    protected static boolean message2ShareIntent (String title, String message, String url, Activity arg0)
    {
        if ( title == null || title.length() == 0 )
        {
            return false;
        }
        if ( message == null || message.length() == 0 )
        {
            return false;
        }
        if ( url == null || url.length() == 0 )
        {
            return false;
        }

        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, title);
        sendIntent.putExtra(android.content.Intent.EXTRA_TEXT, message + " " + url);
        sendIntent.setType("text/plain");
        arg0.startActivityForResult(Intent.createChooser(sendIntent, "シェア"), 1000);     
        return true;
    }
    
    protected static boolean message2ShareIntentWithImage (String title, String message, String url, Uri imageUri, Activity arg0)
    {
        if ( title == null || title.length() == 0 )
        {
            return false;
        }
        if ( message == null || message.length() == 0 )
        {
            return false;
        }
        if ( url == null || url.length() == 0 )
        {
            return false;
        }
        if ( imageUri == null )
        {
            return false;
        }

        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_STREAM, imageUri);
        sendIntent.putExtra(android.content.Intent.EXTRA_TEXT, message + " " + url);
        sendIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, title);
        sendIntent.setType("image/png");
        sendIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
        sendIntent.addFlags(Intent.FLAG_GRANT_WRITE_URI_PERMISSION);
        arg0.startActivityForResult(Intent.createChooser(sendIntent, "シェア"), 1000);     
        return true;
    }
}
