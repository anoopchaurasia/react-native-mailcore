
package com.reactlibrary;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.WritableMap;
import com.libmailcore.Address;
import com.libmailcore.AuthType;
import com.libmailcore.ConnectionType;
import com.libmailcore.MailException;
import com.libmailcore.MessageBuilder;
import com.libmailcore.MessageHeader;
import com.libmailcore.OperationCallback;
import com.libmailcore.SMTPOperation;
import com.libmailcore.SMTPSession;

import java.util.ArrayList;

public class RNMailCoreModule extends ReactContextBaseJavaModule {

  private final ReactApplicationContext reactContext;
  private final MailClient mailClient;

  public RNMailCoreModule(ReactApplicationContext reactContext) {
    super(reactContext);
    this.reactContext = reactContext;
    this.mailClient = new MailClient();
  }

  @Override
  public String getName() {
    return "RNMailCore";
  }

  @ReactMethod
  public void loginImap(final ReadableMap obj, final Promise promise){
    getCurrentActivity().runOnUiThread(new Runnable() {
      @Override
      public void run() {
        UserCredential user = new UserCredential(obj);
        mailClient.initIMAPSession(user,promise);
      }
    });
  }

  @ReactMethod
  public void loginSmtp(final ReadableMap obj, final Promise promise){
    getCurrentActivity().runOnUiThread(new Runnable() {
      @Override
      public void run() {
        UserCredential user = new UserCredential(obj);
        mailClient.initSMTPSession(user,promise);
      }
    });
  }

  @ReactMethod
  public void createFolder(final ReadableMap obj,final Promise promise) {
    getCurrentActivity().runOnUiThread(new Runnable() {
      @Override
      public void run() {
        mailClient.createFolderLabel(obj,promise);
      }
    });
  }

  @ReactMethod
  public void renameFolder(final ReadableMap obj,final Promise promise) {
    getCurrentActivity().runOnUiThread(new Runnable() {
      @Override
      public void run() {
        mailClient.renameFolderLabel(obj,promise);
      }
    });
  }

  @ReactMethod
  public void deleteFolder(final ReadableMap obj,final Promise promise) {
    getCurrentActivity().runOnUiThread(new Runnable() {
      @Override
      public void run() {
        mailClient.deleteFolderLabel(obj,promise);
      }
    });
  }
  
  @ReactMethod
  public void getFolders(final Promise promise) {
    getCurrentActivity().runOnUiThread(new Runnable() {
      @Override
      public void run() {
        mailClient.getFolders(promise);
      }
    });
  }
  
  @ReactMethod
  public void moveEmail(final ReadableMap obj, final Promise promise) {
    getCurrentActivity().runOnUiThread(new Runnable() {
      @Override
      public void run() {
        mailClient.moveEmail(obj,promise);
      }
    });
  }

  @ReactMethod
  public void permantDeleteEmail(final ReadableMap obj, final Promise promise) {
    getCurrentActivity().runOnUiThread(new Runnable() {
      @Override
      public void run() {
        mailClient.permantDelete(obj, promise);
      }
    });
  }

  @ReactMethod
  public void actionFlagMessage(final ReadableMap obj, final Promise promise) {
    getCurrentActivity().runOnUiThread(new Runnable() {
      @Override
      public void run() {
        mailClient.ActionFlagMessage(obj, promise);
      }
    });
  }

  @ReactMethod
  public void actionLabelMessage(final ReadableMap obj, final Promise promise) {
    getCurrentActivity().runOnUiThread(new Runnable() {
      @Override
      public void run() {
        mailClient.ActionLabelMessage(obj, promise);
      }
    });
  }

  @ReactMethod
  public void sendMail(final ReadableMap obj, final Promise promise) {
    getCurrentActivity().runOnUiThread(new Runnable() {
      @Override
      public void run() {
        mailClient.sendMail(obj, promise);
      }
    });
  }

  @ReactMethod
  public void getMail(final ReadableMap obj, final Promise promise) {
    getCurrentActivity().runOnUiThread(new Runnable() {
      @Override
      public void run() {
        mailClient.getMail(obj, promise);
      }
    });
  }

@ReactMethod
  public void getAttachment(final ReadableMap obj, final Promise promise) {
    getCurrentActivity().runOnUiThread(new Runnable() {
      @Override
      public void run() {
        mailClient.getAttachment(obj, promise);
      }
    });
  }

  @ReactMethod
  public void getMails(final ReadableMap obj, final Promise promise) {
    getCurrentActivity().runOnUiThread(new Runnable() {
      @Override
      public void run() {
        mailClient.getMails(obj, promise);
      }
    });
  }

  @ReactMethod
  public void getMailsByNumber(final ReadableMap obj, final Promise promise) {
    getCurrentActivity().runOnUiThread(new Runnable() {
      @Override
      public void run() {
        mailClient.getMailsByNumber(obj, promise);
      }
    });
  }

  @ReactMethod
  public void listenChanges(final ReadableMap obj, final Callback errorCallback, final Callback successCallback) {
    getCurrentActivity().runOnUiThread(new Runnable() {
      @Override
      public void run() {
        mailClient.listenChanges(obj, errorCallback, successCallback);
      }
    });
  }

}