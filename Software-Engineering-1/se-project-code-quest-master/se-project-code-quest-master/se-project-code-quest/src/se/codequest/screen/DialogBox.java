package se.codequest.screen;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Dialog;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

import se.codequest.CodeQuest;

public class DialogBox implements Screen{

	String userText;
	Stage stage;
	Skin skin;
	Dialog d;
	TextField t;
	TextButton submit;
	TextButton cancel;
	int questionNum;
	private CodeQuest app;
	public static boolean interaction1Status;
	public static boolean interaction2Status;
	public static boolean question1Correct;


	public DialogBox(CodeQuest app, Stage stage, int questionNum) 
	{
		this.app = app;
		this.stage = stage;
		this.questionNum = questionNum;
		interaction1Status = false;
		interaction2Status = false;
		question1Correct = false;
		newQuestion();
	}

	//Creates a new Text Box
	public void newQuestion() 
	{
		skin = new Skin(Gdx.files.internal("uiskin.json"));
		Gdx.input.setInputProcessor(stage);
		t = new TextField("", skin);

		submit = new TextButton("Submit", skin);
		cancel = new TextButton("Cancel", skin);		
		submit.setPosition(5, -10);

		submit.setColor(Color.GREEN);
		cancel.setColor(Color.RED);
		
		if(questionNum == 1)
		{
			d = new Dialog("Question 1:", skin) 
			{
				public void result(Object obj) 
				{
					System.out.print(obj);
				}
			};
			d.text("What is term for a word in java?");
		}
		else if(questionNum == 2)
		{
			d = new Dialog("Question 2:", skin) 
			{
				public void result(Object obj) 
				{
					System.out.print(obj);
				}
			};
			d.text("Name one type of loop in Java.");
		}

		else if(questionNum == 3)
		{
			d = new Dialog("Question 3:", skin) 
			{
				public void result(Object obj) 
				{
					System.out.print(obj);
				}
			};
			d.text("What is the print statement in Java?");
			d.text("(No new line)");
		}

		else if(questionNum == 4)
		{
			d = new Dialog("Question 4:", skin) 
			{
				public void result(Object obj) 
				{
					System.out.print(obj);
				}
				
			};
			d.text("What is the term for a character in Java?");
		}

		else if(questionNum == 5)
		{
			d = new Dialog("Question 5:", skin) 
			{
				public void result(Object obj) 
				{
					System.out.print(obj);
				}
			};
			d.text("What is the term for a true or false statement in Java?");
		}
		else if(questionNum == 6)
		{
			d = new Dialog("Hello!", skin) 
			{
				public void result(Object obj) 
				{
					System.out.print(obj);
				}
			};
			d.text("Are you looking for the way through?");
		}
		
		else if(questionNum == 7)
		{
			d = new Dialog("They say you're supposed to defeat SegFaulto??", skin) 
			{
				public void result(Object obj) 
				{
					System.out.print(obj);
				}
			};
			d.text("\nYou want a hint from me you say??\n Pshhhh prove your worth traveler! \n What is the term for a true or false statement in Java?\n");
		}

		d.add(t);
		d.row();
		d.add(submit);
		//d.add(cancel);


		submit.addListener(new ClickListener() 
		{
			public void touchUp(InputEvent e, float x, float y, int point, int button)
			{
				checkForCorrectAnswer(questionNum);
			}
		});

		cancel.addListener(new ClickListener() 
		{
			public void clicked(InputEvent event, float x, float y)
			{
				d.hide();
				((Game)Gdx.app.getApplicationListener()).setScreen(new GameScreen(app));
			}
		});


		d.show(stage);
	}
	
	public void checkForCorrectAnswer(int questionNum)
	{
		String answer = t.getText().toString();
		TextButton close = new TextButton("Close", skin);
		if(questionNum == 1)
		{
			if(answer.equals("String")) 
			{
				d.text("CORRECT!");
				submit.setVisible(false);

				close.setColor(Color.RED);
				d.add(close);
				question1Correct = true;

				close.addListener(new ClickListener()
				{
					public void clicked(InputEvent event, float x, float y)
					{
						((Game)Gdx.app.getApplicationListener()).setScreen(new GameScreen(app));
					}
				});
			}
			
			else
			{
				((Game)Gdx.app.getApplicationListener()).setScreen(new DialogBox(app, stage, 1));
			}
		}
		
		else if(questionNum == 2)
		{
			if(answer.equals("for") || answer.equals("while") || answer.equals("do-while")) 
			{
				d.text("CORRECT!");
				submit.setVisible(false);
				cancel.setVisible(false);

				close.setColor(Color.RED);
				d.add(close);

				close.addListener(new ClickListener() 
				{
					public void clicked(InputEvent event, float x, float y)
					{
						((Game)Gdx.app.getApplicationListener()).setScreen(new GameScreen(app));
					}
				});
			}
			
			else
			{
				((Game)Gdx.app.getApplicationListener()).setScreen(new DialogBox(app, stage, 2));
			}
		}
		
		else if(questionNum == 3)
		{
			if(answer.equals("System.out.print")) 
			{
				d.text("CORRECT!");
				submit.setVisible(false);
				cancel.setVisible(false);

				close.setColor(Color.RED);
				d.add(close);

				close.addListener(new ClickListener() {
					public void clicked(InputEvent event, float x, float y)
					{
						((Game)Gdx.app.getApplicationListener()).setScreen(new GameScreen(app));
					}
				});
			}
			
			else
			{
				((Game)Gdx.app.getApplicationListener()).setScreen(new DialogBox(app, stage, 3));
			}
		}
		
		else if(questionNum == 4)
		{
			if(answer.equals("char")) 
			{
				d.text("CORRECT!");
				submit.setVisible(false);
				cancel.setVisible(false);

				close.setColor(Color.RED);
				d.add(close);

				close.addListener(new ClickListener() {
					public void clicked(InputEvent event, float x, float y)
					{
						((Game)Gdx.app.getApplicationListener()).setScreen(new GameScreen(app));
					}
				});
			}
			
			else
			{
				((Game)Gdx.app.getApplicationListener()).setScreen(new DialogBox(app, stage, 4));
			}
		}
		
		if(questionNum == 6)
		{
			if(answer.equals("yes") || answer.equals("Yes")) 
			{
				d.text("\nYou should look\n by the strange rock in the rock wall!");
				submit.setVisible(false);

				close.setColor(Color.RED);
				d.add(close);
				interaction1Status = true;

				close.addListener(new ClickListener()
				{
					public void clicked(InputEvent event, float x, float y)
					{
						((Game)Gdx.app.getApplicationListener()).setScreen(new GameScreen(app));
					}
				});
			}
			
			else
			{
				((Game)Gdx.app.getApplicationListener()).setScreen(new DialogBox(app, stage, 1));
			}
		}
		
		else if(questionNum == 7)
		{
			if(answer.equals("boolean")) 
			{
				d.text("\nCORRECT!\n I'm impressed young traveler,\n your coding skills are amazing!\n "
						+ " Here is a hint,\n you must venture to the area most hidden\n and retrieve the golden chalice\n GOOD LUCK!\n");
				submit.setVisible(false);
				t.setVisible(false);

				close.setColor(Color.RED);
				d.add(close);
				interaction2Status = true;

				close.addListener(new ClickListener()
				{
					public void clicked(InputEvent event, float x, float y)
					{
						((Game)Gdx.app.getApplicationListener()).setScreen(new GameScreen(app));
					}
				});
			}
			
			else
			{
				((Game)Gdx.app.getApplicationListener()).setScreen(new DialogBox(app, stage, 7));
			}
		}
	}
	
	public void render(float delta)
	{
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		stage.act();
		stage.draw();
	}

	public void dispose()
	{
		stage.dispose();
	}

	@Override
	public void hide() {
	// TODO Auto-generated method stub

	}

	@Override
	public void pause() {
	// TODO Auto-generated method stub

	}

	
	public void resize(int arg0, int arg1) {
	// TODO Auto-generated method stub

	}

	@Override
	public void resume() {
	// TODO Auto-generated method stub

	}

	@Override
	public void show() {
	// TODO Auto-generated method stub

	}
}