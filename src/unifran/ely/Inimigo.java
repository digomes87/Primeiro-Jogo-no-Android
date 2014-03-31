package unifran.ely;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class Inimigo extends Retangulo {
	private static Bitmap bmp;
	
	public Inimigo(int x, int y, Resources res) {
		super(x, y, 40, 40);
		if (bmp==null) {
			//instancio a imagem do resource
			bmp = BitmapFactory.decodeResource(res, R.drawable.mosquito);
			//redimensiona imagem
			bmp = Bitmap.createScaledBitmap(bmp, 40, 40, true);
		}
	}
	public void mexe(int height, int width) {
		if (getY()<height) {
			setY(getY()+5);
		} else {
			int x = (int) (Math.random() * (width-25));
			setX(x);
			setY(-25);
		}
	}
	public void draw(Canvas canvas, Paint paint) {
		//paint.setColor(Color.RED);
		//canvas.drawRect(getX(),getY(),
		//		getX()+getWidth(), getY()+getHeight(),
		//		paint);
		canvas.drawBitmap(bmp, getX(), getY(), paint);
	}
}
