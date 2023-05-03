import converter.LongestProject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DatabaseQueryService {

    private static final String FIND_LONGEST_PROJECT_SQL = "sql/find_longest_project.sql";
    private static final String FIND_MAX_PROJECTS_CLIENT_SQL = "sql/find_max_projects_client.sql";
    private static final String FIND_MAX_SALARY_WORKER_SQL = "sql/find_longest_project.sql";
    private static final String FIND_YOUNGEST_ELDEST_WORKERS_SQL = "sql/find_youngest_eldest_workers.sql";
    private static final String FIND_PROJECT_PRICES_SQL = "sql/print_project_prices.sql";
    private final Connection connection = Database.getInstance().getConnection();

    public List<LongestProject> findLongestProject() {
        List<LongestProject> longestProjects = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            String sql = Files.readString(Path.of(FIND_LONGEST_PROJECT_SQL));
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                LongestProject longestProject = new LongestProject();
                longestProject.setId(resultSet.getInt("id"));
                longestProject.setMonthCount(resultSet.getInt("month_count"));
                longestProjects.add(longestProject);
            }
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
        return longestProjects;
    }
}
