# EasingAPI
An API for simple easing functions.

## Example
```java
	public static void main(String[] args) throws IOException {
		//create frame
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800, 600);
		frame.setLocationRelativeTo(null);
		
		Renderer renderer = new Renderer();
		frame.add(renderer);
		
		frame.setVisible(true);
		
		//game loop
		new Thread() {
			public void run() {
				long last = System.currentTimeMillis();
				while(true) {
					renderer.repaint();
					long now = System.currentTimeMillis();
					float delta = (float) (now - last);
					Easing.tick(delta);
					last = now;
					
					try {
						Thread.sleep(1000 / 60 /*60 fps*/);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			};
		}.start();
	}
	
	public static class Renderer extends JLabel {
		private static final long serialVersionUID = 1L;
		
		private double y2 = 100;
		private double x2 = 100;
		
		public Renderer() {
			Easing.start(EasingType.BOUNCE_OUT, 3000, (x, y, dy) -> {
				y2 += dy * 300;
			});
		}
		
		@Override
		public void paint(Graphics g) {
			g.fillRect((int) x2, (int) y2, 100, 100);
		}
		
	}
```
