package gr.aueb.cf.cf9.userapp.gui;

import java.awt.Color;
import java.awt.Font;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

public class Style {
    // Colors
    public static final Color PRIMARY_COLOR = new Color(59, 89, 182); // A nice blue
    public static final Color SECONDARY_COLOR = new Color(242, 242, 242); // Light gray background
    public static final Color TEXT_COLOR = new Color(51, 51, 51); // Dark gray for text
    public static final Color ERROR_COLOR = new Color(217, 83, 79); // Red for errors
    public static final Color SUCCESS_COLOR = new Color(92, 184, 92); // Green for success

    // Fonts
    public static final Font FONT_GENERAL = new Font("Segoe UI", Font.PLAIN, 14);
    public static final Font FONT_HEADER = new Font("Segoe UI", Font.BOLD, 24);
    public static final Font FONT_BUTTON = new Font("Segoe UI", Font.BOLD, 14);

    // Borders and Padding
    public static final Border PADDING = new EmptyBorder(10, 10, 10, 10);
    public static final Border PADDING_LARGE = new EmptyBorder(20, 20, 20, 20);
}
