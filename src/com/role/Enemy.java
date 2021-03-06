package com.role;

import com.ui.GameFrame;

import java.awt.Image;

/*** 障碍物的抽象父类
 * @author 刘坤昊
 * @version 3
 * 障碍物的基本属性和构造方法
 */
public abstract class Enemy {
	public int x, y;
	public int width, height;
	public Image img;
	public boolean isDead = false;

	public Enemy(int x, int y, int width, int height, Image img) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.img = img;
	}

	public Image getImg() {
		return img;
	}

	public void setImg(Image img) {
		this.img = img;
	}
	
	public void dispose(){
	};
}
