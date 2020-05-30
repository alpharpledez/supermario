package com.util;

import com.role.Boom;
import com.ui.GameFrame;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;


//���̰��¼�����
public class KeyListener extends KeyAdapter{

	// ���յ��˵�ǰ�����棺��Ϸ����
	public GameFrame gf;

	public KeyListener(GameFrame gf) {
		this.gf = gf;
	}
	
	//���̼���
	@Override
	public void keyPressed(KeyEvent e) {
		int code = e.getKeyCode();
		switch(code){
			//������
			case 39:
				gf.mario.right=true; // �ź�λ
				break;
			//������
			case 37:
				gf.mario.left=true;
				break;
			case 66:
				addBoom();
				break;
			//������
			case 38:
				gf.mario.up=true;
				break;
			case 82:
				gf.mario.revive();
		}
	}
	
	//�����ӵ�
	public void addBoom() {	
		Boom b = new Boom(gf.mario.x,gf.mario.y+5,10,gf);
		b.speed = gf.mario.isFaceRight?4:-4;
		gf.boomList.add(b);
	}

	//�����ͷż���
	@Override
	public void keyReleased(KeyEvent e) {
		int code=e.getKeyCode();
		if(code==39){
			gf.mario.right=false;
			gf.mario.img=new ImageIcon("image/mari1.png").getImage();
		}
		if(code==37){
			gf.mario.left=false;
			gf.mario.img=new ImageIcon("image/mari_left1.png").getImage();
		}
		if(code==38){
			gf.mario.up=false;
		}

	}

}