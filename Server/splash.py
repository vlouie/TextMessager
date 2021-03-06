import curses
import curses.textpad

def main(screen):
    """screen is a curses screen passed from the wrapper"""

    max_y, max_x = screen.getmaxyx()

    
    pass_screen_h, pass_screen_w = {5, 25}
    
    pass_screen_y_off,pass_screen_x_off = {pass_screen_h/2, pass_screen_w/2}

    pass_text_y_off = 0
    pass_text_x_off = 3

    pass_win = screen.subwin(5, 25,(max_y/2) - pass_screen_y_off, (max_x/2) - pass_screen_x_off)
    pass_win.box()
    pass_win.addstr(1, 2, "Please enter password")

    pass_box = screen.subwin(1, 8,(max_y/2) - pass_text_y_off, (max_x/2) - pass_text_x_off)

#    pass_box.box()
    screen.refresh()
    tb = curses.textpad.Textbox(pass_box)
    
    text = tb.edit()
    while 1:
        c = screen.getch()

if __name__ == '__main__':
    curses.wrapper(main)
