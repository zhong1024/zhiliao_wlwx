//package com.zhiliao.util;
//
//import android.app.Activity;
//import java.util.concurrent.locks.Lock;
//import java.util.concurrent.locks.ReentrantLock;
//import android.os.Bundle;
//import android.view.View;
//import android.view.View.OnClickListener;
//import android.widget.Button;
//import android.widget.EditText;
//import android.widget.TextView;
//import android.widget.Toast;
//import android.os.Handler;
//
//public class MainActivity extends Activity {
//	private Button btn_all, btn_single, btn_address, btn_state, btn_id;
//	private EditText ed_1, ed_2, edState,edBoardAddr;
//	private TextView tvMsg;
//	private Startwrite ss;
//	final int MSG_UPDATE_MSG = 1;
//	private String recv_msg;
//	private Handler handler=null;
//	private Lock lock = new ReentrantLock();
//
//
//	// 构建Runnable对象，在runnable中更新界面
//    Runnable   runnableUi=new  Runnable(){
//        @Override
//        public void run() {
//            //更新界面
//            tvMsg.setText(recv_msg);
//        }
//
//    };
//	@Override
//	protected void onCreate(Bundle savedInstanceState) {
//		super.onCreate(savedInstanceState);
//		setContentView(R.layout.activity_main);
//		ss = new Startwrite();
//		ed_1 = (EditText) findViewById(R.id.editText1);
//		ed_2 = (EditText) findViewById(R.id.editText2);
//		edState = (EditText) findViewById(R.id.editState);
//		edBoardAddr = (EditText) findViewById(R.id.BoardAddr);
//		tvMsg = (TextView) findViewById(R.id.tvMsg);
//		ss.uartInit();
//		handler=new Handler();
//
//		//获取协议ID
//		btn_id = (Button) findViewById(R.id.btn_id);
//		btn_id.requestFocus();
//		btn_id.setOnClickListener(new OnClickListener() {
//			@Override
//			public void onClick(View v) {
//				// TODO Auto-generated method stub
//				String boardNo = edBoardAddr.getText().toString().trim();
//				if ("".equals(boardNo) || null == boardNo) {
//					return;
//				}
//				final int boardNum = Integer.parseInt(boardNo);
//				tvMsg.setText("");
//				int[] buf = new int[16];
//				ss.getProtocalID(boardNum,buf);
//				String str="ID:";
//				for(int i=0; i<5; i++) {
//					str += " "+ Integer.toHexString(buf[i]) + " ";
//				}
//				tvMsg.setText(str);
//			}
//		});
//
//		//获取板卡地址
//		btn_address = (Button) findViewById(R.id.btn_address);
//		btn_address.requestFocus();
//		btn_address.setOnClickListener(new OnClickListener() {
//			@Override
//			public void onClick(View v) {
//				// TODO Auto-generated method stub
//				tvMsg.setText("");
//				int[] buf = new int[16];
//				int num = ss.getBoardAddress(buf);
//				String str="板地址:";
//				for(int i=0; i<num; i++) {
//					str += " "+ Integer.toHexString(buf[i]) + " ";
//				}
//				tvMsg.setText(str);
//			}
//		});
//
//		//获取门状态
//		btn_state = (Button) findViewById(R.id.btn_state);
//		btn_state.setOnClickListener(new OnClickListener() {
//			@Override
//			public void onClick(View v) {
//				// TODO Auto-generated method stub
//				String no = edState.getText().toString().trim();
//				if ("".equals(no) || null == no) {
//					return;
//				}
//
//				final int num = Integer.parseInt(no);
//
//				String boardNo = edBoardAddr.getText().toString().trim();
//				if ("".equals(boardNo) || null == boardNo) {
//					return;
//				}
//				final int boardNum = Integer.parseInt(boardNo);
//				tvMsg.setText("");
//				new Thread(new Runnable() {
//					 @Override
//					 public void run() {
//
//				int[] buf = new int[7];
//
//
//				lock.lock();
//				try {
//					ss.getDoorState(boardNum, num, buf);
//					recv_msg="门状态:";
//					if(num != 0) {
//						for(int i=0; i<5; i++) {
//							recv_msg += " 0x"+ Integer.toHexString(buf[i]) + " ";
//						}
//					} else {
//						for(int i=0; i<7; i++) {
//							recv_msg += " 0x"+ Integer.toHexString(buf[i]) + " ";
//						}
//					}
//					handler.post(runnableUi);
//				} finally {
//				lock.unlock();
//				}
//
//				/*
//				for(int k=1; k<25; k++) {
//					lock.lock();
//				try {
//					ss.getDoorState(boardNum, k, buf);
//					recv_msg="门状态:";
//					if(k != 0) {
//						for(int i=0; i<5; i++) {
//							recv_msg += " 0x"+ Integer.toHexString(buf[i]) + " ";
//						}
//					} else {
//						for(int i=0; i<7; i++) {
//							recv_msg += " 0x"+ Integer.toHexString(buf[i]) + " ";
//						}
//					}
//					handler.post(runnableUi);
//				} finally {
//				lock.unlock();
//				}
//				try {
//					Thread.sleep(1000);
//				} catch (InterruptedException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//
//				}*/
//					 }
//				}).start();
//			}
//		});
//
//
//
//		//娴嬭瘯鎵�湁鐨勬牸瀛�
//		btn_all = (Button) findViewById(R.id.btn_all);
//		btn_all.setOnClickListener(new OnClickListener() {
//
//			@Override
//			public void onClick(View v) {
//				// TODO Auto-generated method stub
//
//				String no = ed_1.getText().toString().trim();
//				if ("".equals(no) || null == no) {
//					return;
//				}
//				tvMsg.setText("");
//				final int num = Integer.parseInt(no);
//				String boardNo = edBoardAddr.getText().toString().trim();
//				if ("".equals(boardNo) || null == boardNo) {
//					return;
//				}
//				final int boardNum = Integer.parseInt(boardNo);
//				 new Thread(new Runnable() {
//					 @Override
//					 public void run() {
//						// TODO Auto-generated method stub
//
//						 int[] buf = new int[5];
//						for (int i = 1; i <= num; i++) {
//							lock.lock();
//							try {
//							ss.openGrid(boardNum, i,buf);
//
//							recv_msg ="打开门 " + i + ":";
//							for(int j=0; j<5; j++) {
//								recv_msg += " 0x"+ Integer.toHexString(buf[j]) + " ";
//							}
//							handler.post(runnableUi);
//							} finally {
//								lock.unlock();
//							}
//							try {
//								Thread.sleep(1000);
//							} catch (InterruptedException e) {
//								// TODO Auto-generated catch block
//								e.printStackTrace();
//							}
//						}
//
//					 }
//					}).start();
//			}
//
//		});
//		//娴嬭瘯鍗曚釜鏍煎瓙
//		btn_single = (Button) findViewById(R.id.btn_single);
//		btn_single.setOnClickListener(new OnClickListener() {
//
//			@Override
//			public void onClick(View v) {
//				// TODO Auto-generated method stub
//
//				String tt = ed_2.getText().toString().trim();
//				if ("".equals(tt) || null == tt) {
//					return;
//				}
//				final int no = Integer.parseInt(tt);
//				String boardNo = edBoardAddr.getText().toString().trim();
//				if ("".equals(boardNo) || null == boardNo) {
//					return;
//				}
//				final int boardNum = Integer.parseInt(boardNo);
//				tvMsg.setText("");
//				new Thread(new Runnable() {
//					 @Override
//					 public void run() {
//
//				int[] buf = new int[5];
//
//				recv_msg="打开门 " + no+":";
//				lock.lock();
//					if(ss.openGrid(boardNum, no, buf) == 0) {
//					for(int i=0; i<5; i++) {
//						recv_msg += " 0x"+ Integer.toHexString(buf[i]) + " ";
//					}
//				} else {
//					recv_msg += " 失败！";
//				}
//					handler.post(runnableUi);
//					lock.unlock();
//
//					 }
//					 }).start();
//			}
//		});
//	}
//
//	@Override
//	protected void onDestroy() {
//		// TODO Auto-generated method stub
//		ss.uartDestroy();
//		super.onDestroy();
//	}
//}
